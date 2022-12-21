package pintar.gasper.backend.webApp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "messenger", schema = "public")
public class Messenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_user")
    private String idUser;

    @Column(name = "id_friend")
    private String idFriend;

    @Column(name = "created_at")
    private String createdAt;

    public Messenger() {}

    public Messenger(Long id, String idUser, String idFriend, String createdAt) {
        this.id = id;
        this.idUser = idUser;
        this.idFriend = idFriend;
        this.createdAt = createdAt;
    }
}