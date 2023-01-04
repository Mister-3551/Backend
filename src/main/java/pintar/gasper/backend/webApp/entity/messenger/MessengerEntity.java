package pintar.gasper.backend.webApp.entity.messenger;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class MessengerEntity {

    @Id
    private Long id;
    private Long idUser;
    private String text;
    private int years;
    private int months;
    private int weeks;
    private int days;
    private int hours;
    private int minutes;

    public MessengerEntity() {}
}