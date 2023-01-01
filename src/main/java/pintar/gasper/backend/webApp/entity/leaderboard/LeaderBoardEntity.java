package pintar.gasper.backend.webApp.entity.leaderboard;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class LeaderBoardEntity {

    @Id
    private Long id;
    private String username;
    private String picture;
    private int rank;
    private float completed;

    public LeaderBoardEntity() {}

    public LeaderBoardEntity(Long id, String username, String picture, int rank, float completed) {
        this.id = id;
        this.username = username;
        this.picture = picture;
        this.rank = rank;
        this.completed = completed;
    }
}