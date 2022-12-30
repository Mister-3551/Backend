package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pintar.gasper.backend.webApp.entity.account.AccountEntity;
import pintar.gasper.backend.webApp.service.AccountService;

@RestController
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/web-sign-in")
    public String webSignIn(@RequestParam(name = "usernameEmail") String usernameEmail, @RequestParam(name = "password") String password) {
        return accountService.webAuthentication(usernameEmail, password);
    }

    @PostMapping("/web-get-user-account-data")
    public AccountEntity getUserAccountData(@RequestParam(name = "idUser") String idUser) {
        return accountService.getUserAccountData(idUser);
    }

    @PostMapping("/web-sign-out")
    public String webSignOut(@RequestParam(name = "idUser") String idUser) {
        return "empty";
    }

    @PostMapping(value = "/web-update-user-account-data")
    public String updateUserAccountData(@RequestParam(name = "idUser") String idUser, @RequestParam(name = "fullName") String fullName, @RequestParam(name = "profilePicture", required = false) MultipartFile profilePicture) throws Exception {
        return accountService.updateUserAccountData(idUser, fullName, profilePicture);
    }
}