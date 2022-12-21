package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pintar.gasper.backend.webApp.object.SearchUser;
import pintar.gasper.backend.webApp.object.UserAccount;
import pintar.gasper.backend.webApp.service.WebUserService;

import java.util.ArrayList;

@RestController
public class WebUserController {

    private WebUserService webUserService;

    @Autowired
    public WebUserController(WebUserService webUserService) {
        this.webUserService = webUserService;
    }

    @PostMapping("/web-sign-in")
    public String webSignIn(@RequestParam(name = "usernameEmail") String usernameEmail, @RequestParam(name = "password") String password) {
        return webUserService.webAuthentication(usernameEmail, password);
    }

    @PostMapping("/web-get-user-account-data")
    public UserAccount getUserAccountData(@RequestParam(name = "idUser") String idUser) {
        return webUserService.getUserAccountData(idUser);
    }

    @PostMapping("/web-get-users-by-search")
    public ArrayList<SearchUser> getUsersBySearch(@RequestParam(name = "username") String username) {
        return webUserService.getUsersBySearch(username);
    }

    @PostMapping("/web-sign-out")
    public String webSignOut(@RequestParam(name = "idUser") String idUser) {
        return "empty";
    }
}