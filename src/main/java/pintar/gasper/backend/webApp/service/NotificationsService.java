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
            notifications.add(new Notifications(Long.parseLong(word[0]), word[1], Integer.parseInt(word[2]), calculateTime(Integer.parseInt(word[3]), Integer.parseInt(word[4]))));
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


    private String calculateTime(int hours, int minutes) {
        int years = 0;
        int days = 0;

        String date = "";

        if ((hours / 24.0f) / 365.25f > 0) {
            years += (int) ((hours / 24.0f) / 365.25f);
            date = years + "y";
        } else {
            if (hours > 24) {
                days = hours / 24;
                hours %= 24;
                date = days + "d";
            } else if (hours < 1) date = minutes + "m";
            else if (hours >= 1 && hours < 24) date = hours + "h";

            if (minutes == 0) date = "less than a minute";
            else if (minutes >= 1 && minutes < 60) date = minutes + "m";
        }

        return date + " ago";
    }
}