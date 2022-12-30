package pintar.gasper.backend.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pintar.gasper.backend.webApp.entity.account.AccountEntity;
import javax.transaction.Transactional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {

    @Query(value = "SELECT u.id, u.name, u.username, u.email, r.role " +
            "FROM users u " +
            "LEFT JOIN roles r ON r.id_user = u.id " +
            "WHERE u.username = :usernameEmail AND u.password = :password OR u.email = :usernameEmail AND u.password = :password", nativeQuery = true)
    AccountEntity findUser(String usernameEmail, String password);

    @Query(value = "SELECT u.id, u.name, u.username, u.email, null AS role " +
            "FROM users u " +
            "WHERE u.id = :idUser", nativeQuery = true)
    AccountEntity getUserAccountData(String idUser);

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