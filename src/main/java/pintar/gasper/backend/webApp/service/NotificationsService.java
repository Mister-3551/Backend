package pintar.gasper.backend.webApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pintar.gasper.backend.webApp.entity.notifications.Notification;
import pintar.gasper.backend.webApp.entity.notifications.NotificationsEntity;
import pintar.gasper.backend.webApp.repository.NotificationsRepository;
import pintar.gasper.backend.webApp.service.time.TimeChanger;

import java.util.ArrayList;

@Component
public class NotificationsService {

    private NotificationsRepository notificationsRepository;

    @Autowired
    public NotificationsService(NotificationsRepository notificationsRepository) {
        this.notificationsRepository = notificationsRepository;
    }

    public ArrayList<Notification> getUserNotifications(String idUser) {
        var notifications = notificationsRepository.getUserNotifications(idUser);
        ArrayList<Notification> newNotifications = new ArrayList<>();

        for (NotificationsEntity notification : notifications) {
            newNotifications.add(new Notification(notification.getId(), notification.getUsername(), notification.getPicture(), notification.getType(), TimeChanger.calculateTime(notification.getYears(), notification.getMonths(), notification.getWeeks(), notification.getDays(), notification.getHours(), notification.getMinutes())));
        }
        return newNotifications;
    }

    public int insertUserNotifications(String idUser, String username, String type) {
        return notificationsRepository.insertUserNotifications(idUser, username, type);
    }

    public int deleteUserNotifications(String idUser, String username, String type) {
        return notificationsRepository.deleteUserNotifications(idUser, username, type);
    }

    public int deleteUserNotificationsById(String idNotification) {
        return notificationsRepository.deleteUserNotificationsById(idNotification);
    }
}