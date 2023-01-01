package pintar.gasper.backend.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pintar.gasper.backend.webApp.entity.leaderboard.LeaderBoardEntity;

import java.util.ArrayList;

@Repository
public interface LeaderBoardRepository extends JpaRepository<LeaderBoardEntity, String> {

    @Query(value = "SELECT u.id, u.username, u.picture, s.rank, " +
            "ROUND((SELECT COUNT(ls.id) " +
            "       FROM levels_completed ls " +
            "       WHERE ls.completed = '1' AND ls.id_user = u.id) " +
            " / (SELECT COUNT(l.id) AS levels " +
            "    FROM levels l), 3) * 100 AS completed " +
            "FROM users u " +
            "LEFT JOIN statistics s ON s.id_user = u.id " +
            "LEFT JOIN roles r ON r.id_user = u.id " +
            "WHERE r.role != 'ADMIN' " +
            "ORDER BY completed DESC, s.rank DESC LIMIT 10", nativeQuery = true)
    ArrayList<LeaderBoardEntity> getLeaderBoardStatistics();
}