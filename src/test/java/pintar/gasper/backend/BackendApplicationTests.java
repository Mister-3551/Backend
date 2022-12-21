package pintar.gasper.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pintar.gasper.backend.webApp.object.Notifications;
import pintar.gasper.backend.webApp.service.NotificationsService;

import java.util.ArrayList;

@SpringBootTest
class BackendApplicationTests {

    private NotificationsService notificationsService;

    @Autowired
    public BackendApplicationTests(NotificationsService notificationsService) {
        this.notificationsService = notificationsService;
    }

    @Test
    void contextLoads() {}

    @Test
    void sendEmail() {}

    @Test
    void date() {
        ArrayList<Notifications> userNotifications = notificationsService.getUserNotifications("3");

        for (Notifications notifications : userNotifications) {
            System.out.println(notifications.getCreatedAt());
        }
    }
}