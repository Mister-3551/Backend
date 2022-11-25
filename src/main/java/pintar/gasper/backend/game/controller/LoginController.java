package pintar.gasper.backend.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pintar.gasper.backend.game.object.Message;
import pintar.gasper.backend.game.service.LoginService;

@RestController
public class LoginController {

    private LoginService service;

    @Autowired
    public LoginController(LoginService service) {
        this.service = service;
    }

    @PostMapping("/sign-in")
    public String signIn(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        return service.authentication(username, password);
    }

    @PostMapping("/sign-out")
    public String signOut(@RequestParam(name = "gameToken") String gameToken) {
        return service.signOut(gameToken);
    }

    @PostMapping("/forgot-password")
    public Message forgotPassword(@RequestParam(name = "email") String email) {
        return new Message.Builder().build();
    }
}