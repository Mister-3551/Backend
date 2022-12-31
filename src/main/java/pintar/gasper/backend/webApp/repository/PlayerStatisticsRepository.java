package pintar.gasper.backend.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pintar.gasper.backend.webApp.entity.playerstatistics.PlayerStatistics;

public interface PlayerStatisticsRepository extends JpaRepository<PlayerStatistics, String> {

    @Query(value = "SELECT u.id, u.username, u.rank, u.current_xp, u.next_level_xp, u.picture, s.kills, s.deaths, s.wins, s.losses, s.highest_streak, s.most_kills, CASE WHEN s.deaths = 0 THEN s.kills ELSE ROUND(s.kills / s.deaths, 1) END as ratio " +
            "FROM statistics s " +
            "LEFT JOIN users u ON u.id = s.id_user " +
            "LEFT JOIN users u1 ON u.username = :idUserOrUsername " +
            "WHERE u.id = :idUserOrUsername OR u.id = u1.id", nativeQuery = true)
    PlayerStatistics getPlayerStatistics(String idUserOrUsername);

    @Query(value = "SELECT u.username, u.rank, COUNT(lc.id) + 1 AS current_level " +
            "FROM users u " +
            "LEFT JOIN levels_completed lc ON lc.id_user = u.id " +
            "WHERE u.id = :idUser AND lc.completed = '1'", nativeQuery = true)
    String[] getPlayerBasicData(Long idUser);
}