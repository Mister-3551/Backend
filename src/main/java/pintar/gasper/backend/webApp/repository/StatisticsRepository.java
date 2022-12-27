package pintar.gasper.backend.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pintar.gasper.backend.webApp.entity.PlayerStatistics;

public interface StatisticsRepository extends JpaRepository<PlayerStatistics, String> {

    @Query(value = "SELECT u.username, u.rank, u.current_xp, u.next_level_xp, u.picture, s.kills, s.deaths, s.wins, s.losses, s.highest_streak, s.most_kills, CASE WHEN s.deaths = 0 THEN s.kills ELSE ROUND(s.kills / s.deaths, 1) END as ratio " +
            "FROM statistics s " +
            "INNER JOIN users u ON u.id = s.id_user " +
            "WHERE u.id = :idUser", nativeQuery = true)
    String[] getPlayerStatistics(String idUser);

    @Query(value = "SELECT u.username, u.rank, u.current_xp, u.next_level_xp, u.picture, s.kills, s.deaths, s.wins, s.losses, s.highest_streak, s.most_kills, CASE WHEN s.deaths = 0 THEN s.kills ELSE ROUND(s.kills / s.deaths, 1) END as ratio " +
            "FROM statistics s " +
            "INNER JOIN users u ON u.id = s.id_user " +
            "WHERE u.username = :username", nativeQuery = true)
    String[] getWantedPlayerStatistics(String username);

    @Query(value = "SELECT u.username, u.rank " +
            "FROM users u " +
            "WHERE u.id = :idUser", nativeQuery = true)
    String[] getPlayerBasicData(String idUser);

    @Query(value = "SELECT u.id, u.username, u.picture, u.rank, s.kills " +
            "FROM users u " +
            "INNER JOIN statistics s ON s.id_user = u.id " +
            "ORDER BY s.kills DESC, u.rank DESC LIMIT 10", nativeQuery = true)
    String[] getLeaderBoardStatistics();
}
