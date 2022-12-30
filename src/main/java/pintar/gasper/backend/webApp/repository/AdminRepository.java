package pintar.gasper.backend.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pintar.gasper.backend.webApp.entity.admin.AdminEntity;

import javax.transaction.Transactional;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, String> {

    @Query(value = "SELECT r.role " +
            "FROM roles r " +
            "WHERE r.id_user = :idAdmin", nativeQuery = true)
    String checkAdmin(Long idAdmin);

    @Query(value = "SELECT COUNT(l.id) + 1 AS idLevel " +
            "FROM levels l", nativeQuery = true)
    Long getIdLevel();

    @Query(value = "SELECT u.password " +
            "FROM users u " +
            "WHERE u.id = :idAdmin", nativeQuery = true)
    String checkPassword(Long idAdmin);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO levels (id, name, picture, map) VALUES (NULL, :levelName, :levelPicture, :levelMap)", nativeQuery = true)
    int addNewGameLevel(String levelName, String levelPicture, String levelMap);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users " +
            "SET password = :newPassword WHERE id = :idAdmin", nativeQuery = true)
    int updatePassword(String newPassword, Long idAdmin);
}