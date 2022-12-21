package pintar.gasper.backend.webApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pintar.gasper.backend.webApp.object.FollowingFollowers;
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
            notifications.add(new Notifications(Long.parseLong(word[0]), word[1], Integer.parseInt(word[2]), word[3]));
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
}