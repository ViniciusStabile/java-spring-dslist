package dslist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
