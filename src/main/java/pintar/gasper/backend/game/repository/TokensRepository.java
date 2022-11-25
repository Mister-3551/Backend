package pintar.gasper.backend.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pintar.gasper.backend.game.entity.Tokens;

import javax.transaction.Transactional;

@Repository
public interface TokensRepository extends JpaRepository<Tokens, String> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tokens (id, game_token, id_user) VALUES (NULL, :gameToken, :idUser)", nativeQuery = true)
    Integer setGameToken(String gameToken, Long idUser);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tokens WHERE game_token = :gameToken", nativeQuery = true)
    Integer signOut(String gameToken);
}