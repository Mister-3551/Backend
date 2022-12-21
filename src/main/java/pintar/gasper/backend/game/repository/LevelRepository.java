package pintar.gasper.backend.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pintar.gasper.backend.game.entity.Levels;

public interface LevelRepository extends JpaRepository<Levels, String> {

    @Query(value = "SELECT l.name, l.map, CASE WHEN user_levels.completed IS NULL THEN 0 ELSE user_levels.completed END as completed " +
            "FROM levels l " +
            "LEFT JOIN (SELECT DISTINCT lc.id_level as id_level, lc.completed as completed " +
            "           FROM levels_completed lc " +
            "           JOIN users u ON u.id = lc.id_user " +
            "           WHERE u.id = :idUserOrUsername OR u.username = :idUserOrUsername) as user_levels ON user_levels.id_level = l.id", nativeQuery = true)
    String[] getLevels(String idUserOrUsername);
}