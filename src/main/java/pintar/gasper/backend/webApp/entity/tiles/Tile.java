package pintar.gasper.backend.webApp.entity.tiles;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Tile {

    @Id
    private Long id;
    private String name;
    private int size;

    public Tile() {}

    public Tile(Long id, String name, int size) {
        this.id = id;
        this.name = name;
        this.size = size;
    }
}