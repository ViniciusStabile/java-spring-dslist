package dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dslist.DTO.GameDTO;
import dslist.DTO.GameMinDTO;
import dslist.entities.Game;
import dslist.repository.GameRepository;

@Component
public class GameService {

	@Autowired
	private GameRepository repository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> games = repository.findAll();
		List<GameMinDTO> dto = games.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
		
	}
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = repository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
		
	}
}
