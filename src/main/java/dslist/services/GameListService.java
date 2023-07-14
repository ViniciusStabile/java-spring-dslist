package dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dslist.DTO.GameListDTO;
import dslist.entities.GameList;
import dslist.projections.GameMinProjection;
import dslist.repository.GameListRepository;
import dslist.repository.GameRepository;

@Component
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;

	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> list = gameListRepository.findAll();
		return list.stream().map(x -> new GameListDTO(x)).toList();

	}

	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex ;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex ;
	
	for(int i = min; i<=max; i++) {
		gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
	}
	
	}

}