package pintar.gasper.backend.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pintar.gasper.backend.webApp.entity.playerstatistics.PlayerStatistics;

public interface PlayerStatisticsRepository extends JpaRepository<PlayerStatistics, String> {

    @Query(value = "SELECT u.id, u.username, s.rank, s.current_xp, s.next_level_xp, u.picture, " +
            "ROUND((SELECT COUNT(ls.id) " +
            "FROM levels_completed ls " +
            "WHERE ls.completed = '1' AND ls.id_user = u.id) " +
            " / (SELECT COUNT(l.id) AS levels " +
            "    FROM levels l), 3) * 100 AS ratio " +
            "FROM statistics s " +
            "LEFT JOIN users u ON u.id = s.id_user " +
            "LEFT JOIN users u1 ON u.username = :idUserOrUsername " +
            "WHERE u.id = :idUserOrUsername OR u.id = u1.id", nativeQuery = true)
    PlayerStatistics getPlayerStatistics(String idUserOrUsername);

    @Query(value = "SELECT u.username, s.rank, COUNT(lc.id) AS current_level " +
            "FROM users u " +
            "LEFT JOIN levels_completed lc ON lc.id_user = u.id " +
            "LEFT JOIN statistics s ON s.id_user = u.id " +
            "WHERE u.id = :idUser AND lc.completed = '2' OR u.id = :idUser AND lc.completed = '1'", nativeQuery = true)
    String[] getPlayerBasicData(Long idUser);
}
