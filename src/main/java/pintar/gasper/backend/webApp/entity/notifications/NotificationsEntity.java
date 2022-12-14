package pintar.gasper.backend.webApp.entity.notifications;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class NotificationsEntity {

    @Id
    private Long id;
    private String username;
    private String picture;
    private int type;
    private int years;
    private int months;
    private int weeks;
    private int days;
    private int hours;
    private int minutes;

    public NotificationsEntity() {}
}