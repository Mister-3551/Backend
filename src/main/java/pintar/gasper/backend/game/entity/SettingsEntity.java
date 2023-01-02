package pintar.gasper.backend.game.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class SettingsEntity {

    @Id
    private int id;
    private float music;
    private float soundEffect;

    public SettingsEntity() {}

    public SettingsEntity(int id, float music, float soundEffect) {
        this.id = id;
        this.music = music;
        this.soundEffect = soundEffect;
    }
}