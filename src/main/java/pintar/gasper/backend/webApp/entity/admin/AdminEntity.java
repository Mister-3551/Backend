package pintar.gasper.backend.webApp.entity.admin;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class AdminEntity {

    @Id
    private Long id;

    private String usedTime;
    private String currentScore;
    private String maxScore;
    private String deaths;

    public AdminEntity() {}

    public AdminEntity(Long id, String usedTime, String currentScore, String maxScore, String deaths) {
        this.id = id;
        this.usedTime = usedTime;
        this.currentScore = currentScore;
        this.maxScore = maxScore;
        this.deaths = deaths;
    }
}
