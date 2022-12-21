package pintar.gasper.backend.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pintar.gasper.backend.game.entity.Settings;
import pintar.gasper.backend.game.object.Setting;

import java.util.ArrayList;

public interface SettingsRepository extends JpaRepository<Settings, String> {

    @Query(value = "SELECT s.key_left, s.key_right, s.key_jump, s.key_shoot, s.music, s.sound_effect, s.language " +
            "FROM settings s " +
            "WHERE s.id_user = :idUser", nativeQuery = true)
    String[] getSettings(String idUser);
}