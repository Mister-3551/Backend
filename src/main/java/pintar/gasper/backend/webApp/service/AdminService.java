package pintar.gasper.backend.webApp.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pintar.gasper.backend.webApp.repository.AdminRepository;

import java.util.List;

@Component
public class AdminService {

    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<?> addNewGameLevel(String idAdmin, String levelName, MultipartFile levelPicture, MultipartFile levelMap) {
        return adminRepository.getBasic("3", "Training1");
    }

    public List<?> getBasic(String idUser, String mapName) {
        return adminRepository.getBasic(idUser, mapName);
    }
}
