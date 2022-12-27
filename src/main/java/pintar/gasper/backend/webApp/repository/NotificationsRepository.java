package pintar.gasper.backend.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pintar.gasper.backend.webApp.entity.Notifications;

import javax.transaction.Transactional;

@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, String> {

    @Query(value = "SELECT n.id, u.username, u.picture, n.type, " +
            "            TIMESTAMPDIFF(YEAR, TIMESTAMP(n.created_at), NOW()) AS years, " +
            "            MOD(TIMESTAMPDIFF(MONTH, TIMESTAMP(n.created_at), NOW()), 12) AS mohths, " +
            "            CAST((TIMESTAMPDIFF(DAY, TIMESTAMP(n.created_at), NOW()) / 7) AS int) AS weeks, " +
            "            TIMESTAMPDIFF(DAY, TIMESTAMP(n.created_at), NOW()) AS days, " +
            "            MOD(TIMESTAMPDIFF(HOUR, TIMESTAMP(n.created_at), NOW()), 24) AS hours, " +
            "            MOD(TIMESTAMPDIFF(MINUTE, TIMESTAMP(n.created_at), NOW()), 60) AS minutes, " +
            "            MOD(TIMESTAMPDIFF(SECOND, TIMESTAMP(n.created_at), NOW()), 60) AS seconds " +
            "            FROM notifications n " +
            "            LEFT JOIN users u ON u.id = n.id_user " +
            "            WHERE n.id_friend = :idUser " +
            "            ORDER BY n.created_at DESC", nativeQuery = true)
    String[] getUserNotifications(String idUser);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO notifications (id, id_user, id_friend, type, created_at) VALUES (NULL, :idUser, (SELECT u.id " +
            "                                                                                                     FROM users u " +
            "                                                                                                     WHERE u.username = :username), :type, current_timestamp())", nativeQuery = true)
    int insertUserNotifications(String idUser, String username, String type);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM notifications " +
            "WHERE id_friend = (SELECT u.id " +
            "                   FROM users u " +
            "                   WHERE u.username = :username) AND id_user = :idUser AND type = :type", nativeQuery = true)
    int deleteUserNotifications(String idUser, String username, String type);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM notifications " +
            "WHERE id = :idNotification", nativeQuery = true)
    int deleteUserNotificationsById(String idNotification);
}