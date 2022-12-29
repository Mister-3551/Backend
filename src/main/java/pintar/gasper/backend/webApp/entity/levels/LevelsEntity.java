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
    private String map;
    private int completed;

    public LevelsEntity() {}

    public LevelsEntity(Long id, String name, String map, int completed) {
        this.id = id;
        this.name = name;
        this.map = map;
        this.completed = completed;
    }
}
