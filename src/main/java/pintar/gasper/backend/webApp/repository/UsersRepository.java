package pintar.gasper.backend.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pintar.gasper.backend.webApp.entity.users.UsersEntity;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, String> {

    @Query(value = "SELECT CASE WHEN COUNT(ff.id) > 0 THEN 1 ELSE 0 END AS following " +
            "FROM followers_following ff " +
            "LEFT JOIN users u ON u.username = :username " +
            "WHERE ff.id_user = :idUser AND ff.id_friend = u.id", nativeQuery = true)
    String checkIfUserFollow(String idUser, String username);

    @Query(value = "SELECT COUNT(ff.id) AS following " +
            "FROM followers_following ff " +
            "LEFT JOIN users u ON u.id = :idUserOrUsername OR u.username = :idUserOrUsername " +
            "WHERE ff.id_user = u.id", nativeQuery = true)
    int getFollowingCount(String idUserOrUsername);

    @Query(value = "SELECT COUNT(ff.id) AS following " +
            "FROM followers_following ff " +
            "LEFT JOIN users u ON u.id = :idUserOrUsername OR u.username = :idUserOrUsername " +
            "WHERE ff.id_friend = u.id", nativeQuery = true)
    int getFollowersCount(String idUserOrUsername);

    @Query(value = "SELECT u.id, u.username, u.rank, u.picture FROM followers_following ff " +
            "LEFT JOIN users u ON u.id = ff.id_user " +
            "LEFT JOIN users u1 ON u1.id = :idUserOrUsername OR u1.username = :idUserOrUsername " +
            "WHERE ff.id_friend = u1.id", nativeQuery = true)
    ArrayList<UsersEntity> getUserFollowers(String idUserOrUsername);

    @Query(value = "SELECT u.id, u.username, u.rank, u.picture FROM followers_following ff " +
            "LEFT JOIN users u ON u.id = ff.id_friend " +
            "LEFT JOIN users u1 ON u1.id = :idUserOrUsername OR u1.username = :idUserOrUsername " +
            "WHERE ff.id_user = u1.id", nativeQuery = true)
    ArrayList<UsersEntity> getUserFollowing(String idUserOrUsername);

    @Query(value = "SELECT u.id, u.username, u.rank, u.picture " +
            "FROM users u " +
            "LEFT JOIN roles r ON r.id_user = u.id " +
            "WHERE u.username LIKE %:username% AND r.role = 'USER' " +
            "ORDER BY u.rank DESC", nativeQuery = true)
    String[] getUsersBySearch(String username);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO followers_following (id, id_user, id_friend, created_at) " +
            "SELECT NULL, :idUser, u.id, current_timestamp() " +
            "FROM users u " +
            "WHERE u.username = :username", nativeQuery = true)
    void insertUserFollow(String idUser, String username);

    @Modifying
    @Transactional
    @Query(value = "DELETE ff " +
            "FROM followers_following ff " +
            "LEFT JOIN users u ON u.username = :username " +
            "WHERE ff.id_user = :idUser " +
            "AND ff.id_friend = u.id", nativeQuery = true)
    void removeUserFollow(String idUser, String username);
}