package pintar.gasper.backend.webApp.entity.admin;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class AdminEntity {

    @Id
    private Long id;
    private String usersCount;

    public AdminEntity() {}
}