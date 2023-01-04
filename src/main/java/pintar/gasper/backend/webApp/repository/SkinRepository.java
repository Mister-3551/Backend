package pintar.gasper.backend.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pintar.gasper.backend.webApp.entity.skins.SkinEntity;

import java.util.ArrayList;

@Repository
public interface SkinRepository extends JpaRepository<SkinEntity, Long> {

    @Query(value = "SELECT s.id, s.name, s.picture FROM skins_owned so " +
            "LEFT JOIN skins s ON s.id = so.id_skin " +
            "LEFT JOIN users u ON u.username = :idUserOrUsername " +
            "WHERE so.id_user = :idUserOrUsername OR so.id_user = u.id", nativeQuery = true)
    ArrayList<SkinEntity> getSkins(String idUserOrUsername);
}
