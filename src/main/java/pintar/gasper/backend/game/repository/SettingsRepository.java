package pintar.gasper.backend.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pintar.gasper.backend.game.entity.SettingsEntity;

public interface SettingsRepository extends JpaRepository<SettingsEntity, Long> {

    @Query(value = "SELECT s.key_left, s.key_right, s.key_jump, s.key_shoot, s.music, s.sound_effect, s.language " +
            "FROM settings s " +
            "WHERE s.id_user = :idUser", nativeQuery = true)
    SettingsEntity getSettings(Long idUser);
}