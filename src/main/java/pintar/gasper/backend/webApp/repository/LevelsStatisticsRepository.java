package pintar.gasper.backend.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pintar.gasper.backend.webApp.entity.levels.LevelsStatisticsEntity;

import java.util.ArrayList;

@Repository
public interface LevelsStatisticsRepository extends JpaRepository<LevelsStatisticsEntity, String>  {

    @Query(value = "SELECT ls.id, ls.used_time, ls.current_score, ls.max_score, ls.deaths " +
            "FROM levels_statistics ls " +
            "LEFT JOIN levels l ON l.id = ls.id_level " +
            "LEFT JOIN users u ON u.username = :idUserOrUsername " +
            "WHERE ls.id_user = :idUserOrUsername AND REPLACE(l.name, ' ', '') = :mapName OR ls.id_user = u.id AND REPLACE(l.name, ' ', '') = :mapName " +
            "ORDER BY ls.used_time ASC", nativeQuery = true)
    ArrayList<LevelsStatisticsEntity> getLevelsStatistics(String idUserOrUsername, String mapName);

    @Query(value = "SELECT l.name FROM levels l WHERE REPLACE(l.name, ' ', '') = :mapName", nativeQuery = true)
    String getLevelName(String mapName);
}