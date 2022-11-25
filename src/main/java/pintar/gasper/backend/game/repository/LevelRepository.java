package pintar.gasper.backend.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pintar.gasper.backend.game.entity.Levels;

public interface LevelRepository extends JpaRepository<Levels, String> {

    @Query(value = "SELECT l.name, l.map, CASE WHEN user_levels.completed IS NULL THEN 0 ELSE user_levels.completed END as completed " +
            "FROM levels l " +
            "LEFT JOIN (SELECT DISTINCT lu.id_level as id_level, lu.completed as completed " +
            "FROM levels_users lu " +
            "JOIN tokens t ON t.id_user = lu.id_user " +
            "WHERE t.game_token = :gameToken) as user_levels ON user_levels.id_level = l.id", nativeQuery = true)
    String[] getLevels(String gameToken);

}