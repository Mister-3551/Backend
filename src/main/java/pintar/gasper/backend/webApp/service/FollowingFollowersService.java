package pintar.gasper.backend.webApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pintar.gasper.backend.webApp.object.FollowingFollowers;
import pintar.gasper.backend.webApp.object.FollowingFollowersCount;
import pintar.gasper.backend.webApp.repository.FollowingFollowersRepository;

import java.util.ArrayList;

@Component
public class FollowingFollowersService {

    private FollowingFollowersRepository followingFollowersRepository;
    private NotificationsService notificationsService;

    @Autowired
    public FollowingFollowersService(FollowingFollowersRepository followingFollowersRepository, NotificationsService notificationsService) {
        this.followingFollowersRepository = followingFollowersRepository;
        this.notificationsService = notificationsService;
    }

    public String checkIfUserFollow(String idUser, String username) {
        return followingFollowersRepository.checkIfUserFollow(idUser, username).matches("1") ? "Following" : "Follow";
    }

    public FollowingFollowersCount getUserFollowingFollowersCount(String idUserOrUsername) {
        int following, followers;
        if (idUserOrUsername.matches("-?\\d+")) {
            following = followingFollowersRepository.getFollowingCountById(idUserOrUsername);
            followers = followingFollowersRepository.getFollowersCountById(idUserOrUsername);
        } else {
            following = followingFollowersRepository.getFollowingCountByUsername(idUserOrUsername);
            followers = followingFollowersRepository.getFollowersCountByUsername(idUserOrUsername);
        }
        return new FollowingFollowersCount(following, followers);
    }

    public String setUserFollow(String idUser, String username, String type) {
        if (type.matches("Following")) {
            followingFollowersRepository.removeUserFollow(idUser, username);
            notificationsService.deleteUserNotifications(idUser, username, "0");
        }
        else {
            followingFollowersRepository.insertUserFollow(idUser, username);
            notificationsService.insertUserNotifications(idUser, username, "0");
        }
        return checkIfUserFollow(idUser, username);
    }

    public ArrayList<FollowingFollowers> getUserFollowing(String idUserOrUsername) {
        String[] list;
        if (idUserOrUsername.matches("-?\\d+")) list = followingFollowersRepository.getUserFollowingById(idUserOrUsername);
        else list = followingFollowersRepository.getUserFollowingByUsername(idUserOrUsername);

        ArrayList<FollowingFollowers> following = new ArrayList();
        for (String string : list) {
            var word = string.split(",");
            following.add(new FollowingFollowers(Long.parseLong(word[0]), word[1], Integer.parseInt(word[2])));
        }
        return following;
    }

    public ArrayList<FollowingFollowers> getUserFollowers(String idUserOrUsername) {

        String[] list;
        if (idUserOrUsername.matches("-?\\d+")) list = followingFollowersRepository.getUserFollowersById(idUserOrUsername);
        else list = followingFollowersRepository.getUserFollowersByUsername(idUserOrUsername);

        ArrayList<FollowingFollowers> followers = new ArrayList();
        for (String string : list) {
            var word = string.split(",");
            followers.add(new FollowingFollowers(Long.parseLong(word[0]), word[1], Integer.parseInt(word[2])));
        }
        return followers;
    }
}