package pintar.gasper.backend.game.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tokens", schema = "public")
public class Tokens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "game_token")
    private String gameToken;

    @Column(name = "id_user")
    private String idUser;
}