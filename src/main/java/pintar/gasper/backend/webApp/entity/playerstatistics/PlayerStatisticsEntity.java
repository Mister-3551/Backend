package pintar.gasper.backend.webApp.entity.playerstatistics;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class PlayerStatisticsEntity {

    @Id
    private Long id;
    private String username;
    private int rank;
    private int currentXp;
    private int nextLevelXp;
    private String picture;
    private float ratio;

    public PlayerStatisticsEntity() {}
}