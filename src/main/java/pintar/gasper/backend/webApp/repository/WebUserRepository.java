package pintar.gasper.backend.webApp.repository;

import net.bytebuddy.dynamic.DynamicType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import pintar.gasper.backend.game.entity.Users;
import pintar.gasper.backend.webApp.object.SearchUser;

import javax.transaction.Transactional;
import java.sql.Blob;
import java.util.List;
import java.util.Optional;

@Repository
public interface WebUserRepository extends JpaRepository<Users, String> {

    @Query(value = "SELECT u.id, u.name, u.username, u.email " +
            "FROM users u " +
            "WHERE u.username = :usernameEmail AND u.password = :password OR u.email = :usernameEmail AND u.password = :password", nativeQuery = true)
    String[] findUser(String usernameEmail, String password);

    @Query(value = "SELECT u.name, u.username, u.email " +
            "FROM users u " +
            "WHERE u.id = :idUser", nativeQuery = true)
    String[] getUserAccountData(String idUser);

    @Query(value = "SELECT u.id, u.username, u.rank, u.picture " +
            "FROM users u " +
            "WHERE u.username LIKE %:username% " +
            "ORDER BY u.rank DESC", nativeQuery = true)
    String[] getUsersBySearch(String username);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users " +
            "SET name = :fullName, picture = :filename " +
            "WHERE id = :idUser", nativeQuery = true)
    int updateProfileWithPicture(String idUser, String fullName, String filename);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users " +
            "SET name = :fullName " +
            "WHERE id = :idUser", nativeQuery = true)
    int updateProfileWithoutPicture(String idUser, String fullName);
}