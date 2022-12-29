package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pintar.gasper.backend.webApp.entity.users.UsersEntity;
import pintar.gasper.backend.webApp.entity.users.UsersCount;
import pintar.gasper.backend.webApp.service.UsersService;

import java.util.ArrayList;

@RestController
public class UsersController {

    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/web-check-if-user-follow")
    public String checkIfUserFollow(@RequestParam(name = "idUser") String idUser, @RequestParam(name = "username") String username) {
        return usersService.checkIfUserFollow(idUser, username);
    }

    @PostMapping("/web-get-following-followers-count")
    public UsersCount checkIfUserFollow(@RequestParam(name = "idUserOrUsername") String idUserOrUsername) {
        return usersService.getUserFollowingFollowersCount(idUserOrUsername);
    }

    @PostMapping("/web-set-user-follow")
    public String setUserFollow(@RequestParam(name = "idUser") String idUser, @RequestParam(name = "username") String username, @RequestParam(name = "type") String type) {
        return usersService.setUserFollow(idUser, username, type);
    }

    @PostMapping("/web-get-user-following")
    public ArrayList<UsersEntity> getUserFollowing(@RequestParam(name = "idUserOrUsername") String idUserOrUsername) {
        return usersService.getUserFollowing(idUserOrUsername);
    }

    @PostMapping("/web-get-user-followers")
    public ArrayList<UsersEntity> getUserFollowers(@RequestParam(name = "idUserOrUsername") String idUserOrUsername) {
        return usersService.getUserFollowers(idUserOrUsername);
    }
}