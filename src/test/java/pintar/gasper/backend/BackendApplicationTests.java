package pintar.gasper.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pintar.gasper.backend.webApp.entity.notifications.Notification;
import pintar.gasper.backend.webApp.service.AdminService;
import pintar.gasper.backend.webApp.service.UsersService;
import pintar.gasper.backend.webApp.service.NotificationsService;

import java.util.ArrayList;

@SpringBootTest
class BackendApplicationTests {


    private NotificationsService notificationsService;
    private AdminService adminService;

    private UsersService usersService;

    @Autowired
    public BackendApplicationTests(NotificationsService notificationsService, AdminService adminService, UsersService usersService) {
        this.notificationsService = notificationsService;
        this.adminService = adminService;
        this.usersService = usersService;
    }

    @Test
    void contextLoads() {}

    @Test
    void sendEmail() {}

    @Test
    void date() {
        ArrayList<Notification> userNotifications = notificationsService.getUserNotifications("3");

        for (Notification notifications : userNotifications) {
            System.out.println(notifications);
        }
    }

    @Test
    void checkList() {

    }

    @Test
    void getUsers() {
        var list = usersService.getUserFollowers("3");
        String s = "";
    }
}