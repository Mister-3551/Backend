package pintar.gasper.backend.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pintar.gasper.backend.webApp.entity.notifications.NotificationsEntity;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface NotificationsRepository extends JpaRepository<NotificationsEntity, String> {

    @Query(value = "SELECT n.id, u.username, u.picture, n.type, " +
            "TIMESTAMPDIFF(YEAR, TIMESTAMP(n.created_at), NOW()) AS years, " +
            "MOD(TIMESTAMPDIFF(MONTH, TIMESTAMP(n.created_at), NOW()), 12) AS months, " +
            "FLOOR(CAST((TIMESTAMPDIFF(DAY, TIMESTAMP(n.created_at), NOW()) / 7) AS double)) AS weeks, " +
            "TIMESTAMPDIFF(DAY, TIMESTAMP(n.created_at), NOW()) AS days, " +
            "MOD(TIMESTAMPDIFF(HOUR, TIMESTAMP(n.created_at), NOW()), 24) AS hours, " +
            "MOD(TIMESTAMPDIFF(MINUTE, TIMESTAMP(n.created_at), NOW()), 60) AS minutes " +
            "FROM notifications n " +
            "LEFT JOIN users u ON u.id = n.id_user " +
            "WHERE n.id_friend = :idUser " +
            "ORDER BY n.created_at DESC", nativeQuery = true)
    ArrayList<NotificationsEntity> getUserNotifications(String idUser);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO notifications (id, id_user, id_friend, type, created_at) " +
            "SELECT NULL, :idUser, u.id, :type, current_timestamp() " +
            "FROM users u " +
            "WHERE u.username = :username", nativeQuery = true)
    int insertUserNotifications(String idUser, String username, String type);

    @Modifying
    @Transactional
    @Query(value = "DELETE n " +
            "FROM notifications n " +
            "LEFT JOIN users u ON u.username = :username " +
            "WHERE n.id_user = :idUser " +
            "AND n.id_friend = u.id " +
            "AND n.type = :type", nativeQuery = true)
    int deleteUserNotifications(String idUser, String username, String type);

    @Modifying
    @Transactional
    @Query(value = "DELETE n " +
            "FROM notifications n " +
            "WHERE n.id = :idNotification", nativeQuery = true)
    int deleteUserNotificationsById(String idNotification);
}