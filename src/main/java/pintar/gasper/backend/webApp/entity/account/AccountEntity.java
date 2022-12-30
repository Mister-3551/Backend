package pintar.gasper.backend.webApp.entity.account;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class AccountEntity {

    @Id
    private Long id;
    private String name;
    private String username;
    private String email;
    private String role;

    public AccountEntity() {}

    public AccountEntity(Long id, String name, String username, String email, String role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.role = role;
    }
}