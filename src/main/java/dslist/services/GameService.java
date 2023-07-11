package dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dslist.DTO.GameMinDTO;
import dslist.entities.Game;
import dslist.repository.GameRepository;

@Component
public class GameService {

	@Autowired
	private GameRepository repository;
	
	public List<GameMinDTO> findAll() {
		List<Game> games = repository.findAll();
		List<GameMinDTO> dto = games.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
		
	}
}
