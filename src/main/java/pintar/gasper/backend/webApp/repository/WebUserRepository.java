package pintar.gasper.backend.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pintar.gasper.backend.game.entity.Users;

@Repository
public interface WebUserRepository extends JpaRepository<Users, String> {

    @Query(value = "SELECT u.id, u.name, u.username, u.email " +
            "FROM users u " +
            "WHERE u.username = :usernameEmail AND u.password = :password OR u.email = :usernameEmail AND u.password = :password", nativeQuery = true)
    String[] findUser(String usernameEmail, String password);

    @Query(value = "SELECT u.name, u.email " +
            "FROM users u " +
            "WHERE u.id = :idUser", nativeQuery = true)
    String[] getUserAccountData(String idUser);

    @Query(value = "SELECT u.id, u.username, u.rank " +
            "FROM users u " +
            "WHERE u.username LIKE %:username% " +
            "ORDER BY u.rank DESC", nativeQuery = true)
    String[] getUsersBySearch(String username);
}