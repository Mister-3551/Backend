package pintar.gasper.backend.webApp.entity.users;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class UsersEntity {

    @Id
    private Long id;
    private String username;
    private int rank;
    private String picture;

    public UsersEntity() {}

    public UsersEntity(Long id, String username, int rank, String picture) {
        this.id = id;
        this.username = username;
        this.rank = rank;
        this.picture = picture;
    }
}
