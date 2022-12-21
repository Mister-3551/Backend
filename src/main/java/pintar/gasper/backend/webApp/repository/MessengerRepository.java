package pintar.gasper.backend.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pintar.gasper.backend.webApp.entity.Messenger;

@Repository
public interface MessengerRepository extends JpaRepository<Messenger, String> {

    @Query(value = "SELECT u.id, u.username, u.rank FROM messenger m " +
            "LEFT JOIN users u ON u.id = m.id_friend " +
            "WHERE m.id_user = :idUser", nativeQuery = true)
    String[] getUserMessengerFriends(String idUser);


    @Query(value = "SELECT ms.id_user, ms.text, ms.created_at " +
            "FROM messages ms " +
            "WHERE ms.id_user = :idUser AND ms.id_friend = (SELECT u.id " +
            "                                         FROM users u " +
            "                                         WHERE u.username = :username) " +
            "OR ms.id_friend = :idUser AND ms.id_user = (SELECT u.id " +
            "                                         FROM users u " +
            "                                         WHERE u.username = :username) " +
            "ORDER BY ms.created_at ASC", nativeQuery = true)
    String[] getConversation(String idUser, String username);
}
