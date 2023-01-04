package pintar.gasper.backend.webApp.entity.levels;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class LevelsStatisticsEntity {

    @Id
    private Long id;
    private String usedTime;
    private int currentScore;
    private int maxScore;
    private int deaths;

    public LevelsStatisticsEntity() {}
}