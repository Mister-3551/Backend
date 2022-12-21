package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pintar.gasper.backend.webApp.object.FollowingFollowers;
import pintar.gasper.backend.webApp.object.FollowingFollowersCount;
import pintar.gasper.backend.webApp.service.FollowingFollowersService;

import java.util.ArrayList;

@RestController
public class FollowingFollowersController {

    private FollowingFollowersService followingFollowersService;

    @Autowired
    public FollowingFollowersController(FollowingFollowersService followingFollowersService) {
        this.followingFollowersService = followingFollowersService;
    }

    @PostMapping("/web-check-if-user-follow")
    public String checkIfUserFollow(@RequestParam(name = "idUser") String idUser, @RequestParam(name = "username") String username) {
        return followingFollowersService.checkIfUserFollow(idUser, username);
    }

    @PostMapping("/web-get-following-followers-count")
    public FollowingFollowersCount checkIfUserFollow(@RequestParam(name = "idUserOrUsername") String idUserOrUsername) {
        return followingFollowersService.getUserFollowingFollowersCount(idUserOrUsername);
    }

    @PostMapping("/web-set-user-follow")
    public String setUserFollow(@RequestParam(name = "idUser") String idUser, @RequestParam(name = "username") String username, @RequestParam(name = "type") String type) {
        return followingFollowersService.setUserFollow(idUser, username, type);
    }

    @PostMapping("/web-get-user-following")
    public ArrayList<FollowingFollowers> getUserFollowing(@RequestParam(name = "idUserOrUsername") String idUserOrUsername) {
        return followingFollowersService.getUserFollowing(idUserOrUsername);
    }

    @PostMapping("/web-get-user-followers")
    public ArrayList<FollowingFollowers> getUserFollowers(@RequestParam(name = "idUserOrUsername") String idUserOrUsername) {
        return followingFollowersService.getUserFollowers(idUserOrUsername);
    }
}