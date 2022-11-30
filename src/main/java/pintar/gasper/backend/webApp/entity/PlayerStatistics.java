package pintar.gasper.backend.webApp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "statistics", schema = "public")
public class PlayerStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "kills")
    private String kills;

    @Column(name = "deaths")
    private String deaths;

    @Column(name = "wins")
    private String wins;

    @Column(name = "losses")
    private String losses;

    @Column(name = "highest_streak")
    private String highestStreak;

    @Column(name = "most_kills")
    private String mostKills;

    @Column(name = "id_user")
    private String idUser;

    public PlayerStatistics() {}

    public PlayerStatistics(Long id, String kills, String deaths, String wins, String losses, String highestStreak, String mostKills, String idUser) {
        this.id = id;
        this.kills = kills;
        this.deaths = deaths;
        this.wins = wins;
        this.losses = losses;
        this.highestStreak = highestStreak;
        this.mostKills = mostKills;
        this.idUser = idUser;
    }
}