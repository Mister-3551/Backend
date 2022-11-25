package pintar.gasper.backend.game.entity;

import lombok.Data;
import pintar.gasper.backend.game.object.Level;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "levels", schema = "public")
public class Levels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "map")
    private String map;

    public Levels() {}

    public Levels(Long id, String name, String map) {
        this.id = id;
        this.name = name;
        this.map = map;
    }
}