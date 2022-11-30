package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pintar.gasper.backend.webApp.service.WebLoginService;

@RestController
public class WebLoginController {

    private WebLoginService webLoginService;

    @Autowired
    public WebLoginController(WebLoginService webLoginService) {
        this.webLoginService = webLoginService;
    }

    @PostMapping("/web-sign-in")
    public String webSignIn(@RequestParam(name = "usernameEmail") String usernameEmail, @RequestParam(name = "password") String password) {
        return webLoginService.webAuthentication(usernameEmail, password);
    }
}