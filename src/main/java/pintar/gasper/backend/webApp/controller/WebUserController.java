package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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

    @PostMapping(value = "/web-update-user-account-data")
    public String updateUserAccountData(@RequestParam(name = "idUser") String idUser, @RequestParam(name = "fullName") String fullName, @RequestParam(name = "profileImage", required = false) MultipartFile profileImage) throws Exception {
        return webUserService.updateUserAccountData(idUser, fullName, profileImage);
    }

    @GetMapping("/profile-images/{filename}")
    public ResponseEntity<byte[]> getImage(@PathVariable("filename") String filename) throws Exception {
        return webUserService.getImage(filename);
    }

    @GetMapping("/profile-images-update/{filename}")
    public ResponseEntity<byte[]> getImageUpdate(@PathVariable("filename") String filename) throws Exception {
        return webUserService.getImage(filename);
    }
}