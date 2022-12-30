package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pintar.gasper.backend.webApp.service.AdminService;

import java.util.List;

@RestController
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping(value = "/web-add-new-game-level")
    public String addNewGameLevel(@RequestParam(name = "idAdmin") Long idAdmin, @RequestParam(name = "levelName") String levelName, @RequestParam(name = "levelPicture", required = false) MultipartFile levelPicture, @RequestParam(name = "levelMap", required = false) MultipartFile levelMap) throws Exception {
        return adminService.addNewGameLevel(idAdmin, levelName, levelPicture, levelMap);
    }

    @PostMapping(value = "/web-change-password")
    public String changePassword(@RequestParam(name = "idAdmin") Long idAdmin, @RequestParam(name = "currentPassword") String currentPassword, @RequestParam(name = "newPassword") String newPassword, @RequestParam(name = "confirmPassword") String confirmPassword) {
        return adminService.changePassword(idAdmin, currentPassword, newPassword, confirmPassword);
    }
}