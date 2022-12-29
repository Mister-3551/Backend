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
    public List<?> addNewGameLevel(@RequestParam(name = "idAdmin") String idAdmin, @RequestParam(name = "levelName") String levelName, @RequestParam(name = "levelPicture") MultipartFile levelPicture, @RequestParam(name = "levelMap") MultipartFile levelMap) throws Exception {
        return adminService.addNewGameLevel(idAdmin, levelName, levelPicture, levelMap);
    }
}
