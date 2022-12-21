package pintar.gasper.backend.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pintar.gasper.backend.webApp.entity.LevelsStatistics;

@Repository
public interface LevelsStatisticsRepository extends JpaRepository<LevelsStatistics, String>  {

    @Query(value = "SELECT ls.used_time, ls.current_score, ls.max_score, ls.deaths " +
            "            FROM levels_statistics ls " +
            "            LEFT JOIN levels l ON l.id = ls.id_level " +
            "            WHERE ls.id_user = :idUser AND REPLACE(l.name, ' ', '') = :mapName" +
            "            ORDER BY ls.used_time ASC", nativeQuery = true)
    String[] getLevelsStatistics(String idUser, String mapName);

    @Query(value = "SELECT ls.used_time, ls.current_score, ls.max_score, ls.deaths " +
            "          FROM levels_statistics ls " +
            "          LEFT JOIN levels l ON l.id = ls.id_level " +
            "             WHERE ls.id_user = (SELECT u.id " +
            "                                FROM users u " +
            "                                WHERE u.username = :username) AND REPLACE(l.name, ' ', '') = :mapName " +
            "               ORDER BY ls.used_time ASC", nativeQuery = true)
    String[] getWantedLevelsStatistics(String username, String mapName);

    @Query(value = "SELECT l.name FROM levels l WHERE REPLACE(l.name, ' ', '') = :mapName", nativeQuery = true)
    String getLevelName(String mapName);
}