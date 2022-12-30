package pintar.gasper.backend.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pintar.gasper.backend.webApp.entity.leaderboard.LeaderBoardEntity;

import java.util.ArrayList;

@Repository
public interface LeaderBoardRepository extends JpaRepository<LeaderBoardEntity, String> {

    @Query(value = "SELECT u.id, u.username, u.picture, u.rank, s.kills " +
            "FROM users u " +
            "INNER JOIN statistics s ON s.id_user = u.id " +
            "INNER JOIN roles r ON r.id_user = u.id " +
            "WHERE r.role != 'ADMIN' " +
            "ORDER BY s.kills DESC, u.rank DESC LIMIT 10", nativeQuery = true)
    ArrayList<LeaderBoardEntity> getLeaderBoardStatistics();
}