package pintar.gasper.backend.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pintar.gasper.backend.webApp.entity.messenger.MessengerEntity;

import java.util.ArrayList;

@Repository
public interface MessengerRepository extends JpaRepository<MessengerEntity, String> {

    @Query(value = "SELECT u.id, u.username, u.rank, u.picture FROM messenger m " +
            "LEFT JOIN users u ON u.id = m.id_friend " +
            "WHERE m.id_user = :idUser", nativeQuery = true)
    String[] getUserMessengerFriends(String idUser);


    @Query(value = "SELECT ms.id, ms.id_user, ms.text, " +
            "TIMESTAMPDIFF(YEAR, TIMESTAMP(ms.created_at), " +
            "NOW()) AS years, " +
            "MOD(TIMESTAMPDIFF(MONTH, TIMESTAMP(ms.created_at), NOW()), 12) AS months, " +
            "FLOOR(CAST((TIMESTAMPDIFF(DAY, TIMESTAMP(ms.created_at), NOW()) / 7) AS double)) AS weeks, " +
            "TIMESTAMPDIFF(DAY, TIMESTAMP(ms.created_at), NOW()) AS days, " +
            "MOD(TIMESTAMPDIFF(HOUR, TIMESTAMP(ms.created_at), NOW()), 24) AS hours, " +
            "MOD(TIMESTAMPDIFF(MINUTE, TIMESTAMP(ms.created_at), NOW()), 60) AS minutes " +
            "FROM messages ms LEFT JOIN users u ON u.username = :username " +
            "WHERE ms.id_user = :idUser AND ms.id_friend = u.id OR ms.id_friend = :idUser AND ms.id_user = u.id " +
            "ORDER BY ms.created_at ASC", nativeQuery = true)
    ArrayList<MessengerEntity> getConversation(String idUser, String username);
}
