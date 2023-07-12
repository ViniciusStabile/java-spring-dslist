package dslist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
