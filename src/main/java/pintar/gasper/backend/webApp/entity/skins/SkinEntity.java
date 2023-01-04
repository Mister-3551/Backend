package pintar.gasper.backend.webApp.entity.skins;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class SkinEntity {

    @Id
    private int id;
    private String name;
    private String picture;

    public SkinEntity() {}
}