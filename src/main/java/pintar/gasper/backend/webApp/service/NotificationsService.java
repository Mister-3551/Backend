package pintar.gasper.backend.webApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pintar.gasper.backend.webApp.object.Notifications;
import pintar.gasper.backend.webApp.repository.NotificationsRepository;

import java.util.ArrayList;

@Component
public class NotificationsService {

    private NotificationsRepository notificationsRepository;

    @Autowired
    public NotificationsService(NotificationsRepository notificationsRepository) {
        this.notificationsRepository = notificationsRepository;
    }

    public ArrayList<Notifications> getUserNotifications(String idUser) {
        String[] list = notificationsRepository.getUserNotifications(idUser);

        ArrayList<Notifications> notifications = new ArrayList();
        for (String string : list) {
            var word = string.split(",");
            notifications.add(new Notifications(Long.parseLong(word[0]), word[1], word[2], Integer.parseInt(word[3]), calculateTime(Integer.parseInt(word[4]), Integer.parseInt(word[5]), Integer.parseInt(word[6]), Integer.parseInt(word[7]), Integer.parseInt(word[8]), Integer.parseInt(word[9]))));
        }
        return notifications;
    }

    public String insertUserNotifications(String idUser, String username, String type) {
        return String.valueOf(notificationsRepository.insertUserNotifications(idUser, username, type));
    }

    public String deleteUserNotifications(String idUser, String username, String type) {
        return String.valueOf(notificationsRepository.deleteUserNotifications(idUser, username, type));
    }

    public String deleteUserNotificationsById(String idNotification) {
        return String.valueOf(notificationsRepository.deleteUserNotificationsById(idNotification));
    }


    private String calculateTime(int years, int months, int weeks, int days, int hours, int minutes) {
        String date = "";
        if (years == 0) {
            if (months == 0) {
                if (weeks == 0) {
                    if (days == 0) {
                        if (hours == 0) {
                            if (minutes == 0) date = "less than a minute";
                            else date = minutes + "min";
                        } else date = hours + "h";
                    } else date = days + "d";
                } else date = weeks + "w";
            } else date = months + "m";
        } else date = years + "y";
        return date + " ago";
    }
}