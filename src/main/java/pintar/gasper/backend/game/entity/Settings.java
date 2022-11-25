package pintar.gasper.backend.game.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "settings", schema = "public")
public class Settings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "key_left")
    private String keyLeft;

    @Column(name = "key_right")
    private String keyRight;

    @Column(name = "key_jump")
    private String keyJump;

    @Column(name = "key_shoot")
    private String keyShoot;

    @Column(name = "music")
    private String music;

    @Column(name = "sound_effect")
    private String soundEffect;

    @Column(name = "id_user")
    private String idUser;

    public Settings() {}

    public Settings(String keyLeft, String keyRight, String keyJump, String keyShoot, String music, String soundEffect) {
        this.keyLeft = keyLeft;
        this.keyRight = keyRight;
        this.keyJump = keyJump;
        this.keyShoot = keyShoot;
        this.music = music;
        this.soundEffect = soundEffect;
    }
}