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
    private int kills;
    private int deaths;
    private int wins;
    private int losses;
    private int highestStreak;
    private int mostKills;
    private float ratio;

    public PlayerStatistics() {}

    public PlayerStatistics(Long id, String username, int rank, int currentXp, int nextLevelXp, String picture, int kills, int deaths, int wins, int losses, int highestStreak, int mostKills, float ratio) {
        this.id = id;
        this.username = username;
        this.rank = rank;
        this.currentXp = currentXp;
        this.nextLevelXp = nextLevelXp;
        this.picture = picture;
        this.kills = kills;
        this.deaths = deaths;
        this.wins = wins;
        this.losses = losses;
        this.highestStreak = highestStreak;
        this.mostKills = mostKills;
        this.ratio = ratio;
    }
}