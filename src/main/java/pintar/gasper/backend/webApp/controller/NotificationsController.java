package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pintar.gasper.backend.webApp.entity.notifications.Notification;
import pintar.gasper.backend.webApp.service.NotificationsService;

import java.util.ArrayList;

@RestController
public class NotificationsController {

    private NotificationsService notificationsService;

    @Autowired
    public NotificationsController(NotificationsService notificationsService) {
        this.notificationsService = notificationsService;
    }

    @PostMapping("/web-get-user-notifications")
    public ArrayList<Notification> checkIfUserFollow(@RequestParam(name = "idUser") String idUser) {
        return notificationsService.getUserNotifications(idUser);
    }

    @PostMapping("/web-delete-user-notification")
    public int deleteUserNotification(@RequestParam(name = "idNotification") String idNotification) {
        return notificationsService.deleteUserNotificationsById(idNotification);
    }
}