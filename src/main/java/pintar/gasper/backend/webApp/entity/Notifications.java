package pintar.gasper.backend.webApp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "notifications", schema = "public")
public class Notifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_user")
    private String idUser;

    @Column(name = "id_friend")
    private String idFriend;

    @Column(name = "type")
    private String type;

    @Column(name = "created_at")
    private String createdAt;

    public Notifications() {}

    public Notifications(Long id, String idUser, String idFriend, String type, String createdAt) {
        this.id = id;
        this.idUser = idUser;
        this.idFriend = idFriend;
        this.type = type;
        this.createdAt = createdAt;
    }
}