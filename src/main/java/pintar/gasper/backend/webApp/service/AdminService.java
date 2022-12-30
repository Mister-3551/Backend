package pintar.gasper.backend.webApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import pintar.gasper.backend.webApp.repository.AdminRepository;
import pintar.gasper.backend.webApp.service.uploadfile.FileStorageService;

@Component
public class AdminService {

    private AdminRepository adminRepository;
    private FileStorageService fileStorageService;

    @Autowired
    public AdminService(AdminRepository adminRepository, FileStorageService fileStorageService) {
        this.adminRepository = adminRepository;
        this.fileStorageService = fileStorageService;
    }

    public String addNewGameLevel(Long idAdmin, String levelName, MultipartFile levelPicture, MultipartFile levelMap) throws Exception {

        String levelPictureName = "";
        String levelMapName = "";
        Long idLevel;

        if (levelName.trim().matches("")) return "Level name is missing";
        if (levelPicture == null) return "Level picture is missing";
        if (levelMap == null) return "level map is missing";

        if (!"ADMIN".matches(adminRepository.checkAdmin(idAdmin))) return "Wrong authorization";
        idLevel = adminRepository.getIdLevel();

        if (levelPicture.getSize() > 2097152L) return "Image size is more than 2 MB";
        if (levelPicture.getOriginalFilename().contains("..")) return "Invalid Characters";
        if (!fileStorageService.getFileExtension(levelPicture.getOriginalFilename()).equals("jpg")) return "Wrong file format";
        levelPictureName = fileStorageService.storePicture(String.valueOf(idLevel), levelPicture, "levelPicture");

        if (levelMap.getOriginalFilename().contains("..")) return "Invalid Characters";
        if (!fileStorageService.getFileExtension(levelMap.getOriginalFilename()).equals("tmx")) return "Wrong file format";
        levelMapName = fileStorageService.storePicture(String.valueOf(idLevel), levelMap, "levelMap");

        if (!(adminRepository.addNewGameLevel(levelName, levelPictureName, levelMapName) == 1)) return "Something went wrong";

        return "Level successfully added";
    }

    public String changePassword(Long idAdmin, String currentPassword, String newPassword, String confirmPassword) {
        if (currentPassword.trim().matches("")) return "Current password is missing";
        if (newPassword.trim().matches("")) return "New password is missing";
        if (confirmPassword.trim().matches("")) return "Confirm password is missing";

        if (!currentPassword.matches(adminRepository.checkPassword(idAdmin))) return "Current password is incorrect";
        if (!newPassword.matches(confirmPassword)) return "Passwords do not match";

        if (!(adminRepository.updatePassword(newPassword, idAdmin) == 1)) return "Something went wrong";

        return "Password successfully updated";
    }
}