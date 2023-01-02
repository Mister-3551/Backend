package pintar.gasper.backend.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pintar.gasper.backend.webApp.entity.levels.LevelsEntity;

import java.util.ArrayList;

@Repository
public interface LevelsRepository extends JpaRepository<LevelsEntity, Long> {

    @Query(value = "SELECT l.id, l.name, l.picture, l.map, CASE WHEN user_levels.completed IS NULL THEN 0 ELSE user_levels.completed END as completed " +
            "FROM levels l " +
            "LEFT JOIN (SELECT DISTINCT lc.id_level as id_level, lc.completed as completed " +
            "           FROM levels_completed lc " +
            "           JOIN users u ON u.id = lc.id_user " +
            "           WHERE u.id = :idUserOrUsername OR u.username = :idUserOrUsername) as user_levels ON user_levels.id_level = l.id", nativeQuery = true)
    ArrayList<LevelsEntity> getLevels(String idUserOrUsername);
}
