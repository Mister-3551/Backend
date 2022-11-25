package pintar.gasper.backend.game.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "users", schema = "public")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "rank")
    private Integer rank;

    @Column(name = "current_xp")
    private Integer currentXp;

    @Column(name = "next_level_xp")
    private Integer nextLevelXp;

    @Column(name = "token")
    private String token;

    @Column(name = "email_confirmed")
    private String emailConfirmed;

    @Column(name = "email_token")
    private String emailToken;

    public Users() {}

    public Users(Long id, String name, String username, String email, String password, Integer rank, Integer currentXp, Integer nextLevelXp, String token, String emailConfirmed, String emailToken) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.rank = rank;
        this.currentXp = currentXp;
        this.nextLevelXp = nextLevelXp;
        this.token = token;
        this.emailConfirmed = emailConfirmed;
        this.emailToken = emailToken;
    }
}