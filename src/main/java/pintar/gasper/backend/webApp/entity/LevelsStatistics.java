package pintar.gasper.backend.webApp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "levels_statistics", schema = "public")
public class LevelsStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_level")
    private String idLevel;

    @Column(name = "id_user")
    private String idUser;

    @Column(name = "finish_time")
    private String finishTime;

    @Column(name = "current_score")
    private String currentScore;

    @Column(name = "max_score")
    private String maxScore;

    @Column(name = "deaths")
    private String deaths;

    public LevelsStatistics() {}

    public LevelsStatistics(Long id, String idLevel, String idUser, String finishTime, String currentScore, String maxScore, String deaths) {
        this.id = id;
        this.idLevel = idLevel;
        this.idUser = idUser;
        this.finishTime = finishTime;
        this.currentScore = currentScore;
        this.maxScore = maxScore;
        this.deaths = deaths;
    }
}