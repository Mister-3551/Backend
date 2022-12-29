package pintar.gasper.backend.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pintar.gasper.backend.webApp.entity.admin.AdminEntity;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, String> {

    @Query(value = "SELECT ls.id, ls.used_time, ls.current_score, ls.max_score, ls.deaths " +
            "FROM levels_statistics ls " +
            "LEFT JOIN levels l ON l.id = ls.id_level " +
            "WHERE ls.id_user = :idUser AND REPLACE(l.name, ' ', '') = :mapName " +
            "ORDER BY ls.used_time ASC", nativeQuery = true)
    List<AdminEntity> getBasic(String idUser, String mapName);
}
