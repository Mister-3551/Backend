package pintar.gasper.backend.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pintar.gasper.backend.webApp.entity.FollowingFollowers;

import javax.transaction.Transactional;

@Repository
public interface FollowingFollowersRepository extends JpaRepository<FollowingFollowers, String> {

    @Query(value = "SELECT CASE WHEN COUNT(ff.id) > 0 THEN 1 ELSE 0 END AS following FROM followers_following ff " +
            "            WHERE ff.id_user = :idUser AND ff.id_friend = (SELECT u.id " +
            "                                                                FROM users u " +
            "                                                               WHERE u.username = :username)", nativeQuery = true)
    String checkIfUserFollow(String idUser, String username);

    @Query(value = "SELECT COUNT(ff.id) AS following " +
            "FROM followers_following ff " +
            "WHERE ff.id_user = :idUser", nativeQuery = true)
    int getFollowingCountById(String idUser);

    @Query(value = "SELECT COUNT(ff.id) AS following " +
            "FROM followers_following ff " +
            "WHERE ff.id_friend = :idUser", nativeQuery = true)
    int getFollowersCountById(String idUser);

    @Query(value = "SELECT COUNT(ff.id) AS following " +
            "FROM followers_following ff " +
            "WHERE ff.id_user = (SELECT u.id " +
            "                           FROM users u " +
            "                           WHERE u.username = :username)", nativeQuery = true)
    int getFollowingCountByUsername(String username);

    @Query(value = "SELECT COUNT(ff.id) AS following " +
            "FROM followers_following ff " +
            "WHERE ff.id_friend = (SELECT u.id " +
            "                           FROM users u " +
            "                           WHERE u.username = :username)", nativeQuery = true)
    int getFollowersCountByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO followers_following (id, id_user, id_friend, created_at) VALUES (NULL, :idUser, (SELECT u.id " +
            "                                                                                                         FROM users u " +
            "                                                                                                         WHERE u.username = :username)," +
            "current_timestamp())", nativeQuery = true)
    void insertUserFollow(String idUser, String username);

    @Modifying
    @Transactional
    @Query(value = "DELETE " +
            "FROM followers_following " +
            "WHERE id_user = :idUser " +
            "AND id_friend = (SELECT u.id " +
            "                      FROM users u " +
            "                      WHERE u.username = :username)", nativeQuery = true)
    void removeUserFollow(String idUser, String username);

    @Query(value = "SELECT u.id, u.username, u.rank, u.picture FROM followers_following ff " +
            "LEFT JOIN users u ON u.id = ff.id_user " +
            "WHERE ff.id_friend = :idUser", nativeQuery = true)
    String[] getUserFollowersById(String idUser);

    @Query(value = "SELECT u.id, u.username, u.rank, u.picture FROM followers_following ff " +
            "LEFT JOIN users u ON u.id = ff.id_user " +
            "WHERE ff.id_friend = (SELECT u.id " +
            "                           FROM users u " +
            "                           WHERE u.username = :username)", nativeQuery = true)
    String[] getUserFollowersByUsername(String username);

    @Query(value = "SELECT u.id, u.username, u.rank, u.picture FROM followers_following ff " +
            "LEFT JOIN users u ON u.id = ff.id_friend " +
            "WHERE ff.id_user = :idUser", nativeQuery = true)
    String[] getUserFollowingById(String idUser);

    @Query(value = "SELECT u.id, u.username, u.rank, u.picture FROM followers_following ff " +
            "LEFT JOIN users u ON u.id = ff.id_friend " +
            "WHERE ff.id_user = (SELECT u.id " +
            "                    FROM users u " +
            "                    WHERE u.username = :username)", nativeQuery = true)
    String[] getUserFollowingByUsername(String username);
}