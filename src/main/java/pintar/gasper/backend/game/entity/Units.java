package pintar.gasper.backend.game.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "units", schema = "public")
public class Units {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "health_points")
    private String healthPoints;

    public Units() {}

    public Units(Long id, String name, String healthPoints) {
        this.id = id;
        this.name = name;
        this.healthPoints = healthPoints;
    }
}