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
}