package pintar.gasper.backend.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pintar.gasper.backend.webApp.entity.PlayerStatistics;

public interface PlayerStatsRepository extends JpaRepository<PlayerStatistics, String> {

    @Query(value = "SELECT s.kills, s.deaths, s.wins, s.losses, s.highest_streak, s.most_kills " +
            "FROM statistics s " +
            "WHERE s.id_user = (SELECT t.id_user " +
            "                   FROM tokens t " +
            "                   WHERE t.game_token = :webToken)", nativeQuery = true)
    String[] getPlayerStatistics(String webToken);
}
