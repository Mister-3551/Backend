package pintar.gasper.backend.webApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pintar.gasper.backend.webApp.entity.users.UsersEntity;
import pintar.gasper.backend.webApp.entity.users.UsersCount;
import pintar.gasper.backend.webApp.repository.UsersRepository;

import java.util.ArrayList;

@Component
public class UsersService {

    private UsersRepository usersRepository;
    private NotificationsService notificationsService;

    @Autowired
    public UsersService(UsersRepository usersRepository, NotificationsService notificationsService) {
        this.usersRepository = usersRepository;
        this.notificationsService = notificationsService;
    }

    public String checkIfUserFollow(String idUser, String username) {
        return usersRepository.checkIfUserFollow(idUser, username).matches("1") ? "Following" : "Follow";
    }

    public UsersCount getUserFollowingFollowersCount(String idUserOrUsername) {
        int following = usersRepository.getFollowingCount(idUserOrUsername);
        int followers = usersRepository.getFollowersCount(idUserOrUsername);
        return new UsersCount(following, followers);
    }

    public String setUserFollow(String idUser, String username, String type) {
        if (type.matches("Following")) {
            usersRepository.removeUserFollow(idUser, username);
            notificationsService.deleteUserNotifications(idUser, username, "0");
        }
        else {
            usersRepository.insertUserFollow(idUser, username);
            notificationsService.insertUserNotifications(idUser, username, "0");
        }
        return checkIfUserFollow(idUser, username);
    }

    public ArrayList<UsersEntity> getUserFollowing(String idUserOrUsername) {
        return usersRepository.getUserFollowing(idUserOrUsername);
    }

    public ArrayList<UsersEntity> getUserFollowers(String idUserOrUsername) {
        return usersRepository.getUserFollowers(idUserOrUsername);
    }
}