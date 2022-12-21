package pintar.gasper.backend.webApp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users_friends", schema = "public")
public class FollowingFollowers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "id_friend")
    private Long idFriendUser;

    @Column(name = "time")
    private String time;

    public FollowingFollowers() {}

    public FollowingFollowers(Long id, Long idUser, Long idFriendUser, String time) {
        this.id = id;
        this.idUser = idUser;
        this.idFriendUser = idFriendUser;
        this.time = time;
    }
}