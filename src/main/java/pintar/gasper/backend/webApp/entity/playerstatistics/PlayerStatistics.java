package pintar.gasper.backend.webApp.entity.playerstatistics;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class PlayerStatistics {

    @Id
    private Long id;
    private String username;
    private int rank;
    private int currentXp;
    private int nextLevelXp;
    private String picture;
    private float ratio;

    public PlayerStatistics() {}

    public PlayerStatistics(Long id, String username, int rank, int currentXp, int nextLevelXp, String picture, float ratio) {
        this.id = id;
        this.username = username;
        this.rank = rank;
        this.currentXp = currentXp;
        this.nextLevelXp = nextLevelXp;
        this.picture = picture;
        this.ratio = ratio;
    }
}