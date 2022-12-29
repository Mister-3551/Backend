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

    public MessengerEntity(Long id, Long idUser, String text, int years, int months, int weeks, int days, int hours, int minutes) {
        this.id = id;
        this.idUser = idUser;
        this.text = text;
        this.years = years;
        this.months = months;
        this.weeks = weeks;
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
    }
}