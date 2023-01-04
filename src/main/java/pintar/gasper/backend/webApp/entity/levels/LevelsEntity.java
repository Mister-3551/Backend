package pintar.gasper.backend.webApp.entity.levels;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class LevelsEntity {

    @Id
    private Long id;
    private String name;
    private String picture;
    private String map;
    private int completed;
    private String createdAt;

    public LevelsEntity() {}

    public LevelsEntity(Long id, String name, String picture, String map, int completed, String createdAt) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.map = map;
        this.completed = completed;
        this.createdAt = createdAt;
    }
}