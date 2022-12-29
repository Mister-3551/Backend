package pintar.gasper.backend.webApp.service.uploadfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {

    private final Path profilePicture;
    private final Path levelPicture;
    private final Path levelMap;

    @Autowired
    public FileStorageService(Environment env) throws Exception {
        this.profilePicture = Paths.get(env.getProperty("app.file.upload-dir-profile-picture", "./images/profile-picture"))
                .toAbsolutePath().normalize();
        this.levelPicture = Paths.get(env.getProperty("app.file.upload-dir-level-picture", "./images/level-picture"))
                .toAbsolutePath().normalize();
        this.levelMap = Paths.get(env.getProperty("app.file.upload-dir-level-map", "./images/level-map"))
                .toAbsolutePath().normalize();

        Files.createDirectories(profilePicture);
        Files.createDirectories(levelPicture);
        Files.createDirectories(levelMap);
    }

    public String storePicture(String id, MultipartFile file, String type) throws Exception {

        String fileName;
        Path targetLocation;

        if (type.equals("profilePicture")) {
            fileName = id + "-profile-picture." + getFileExtension(file.getOriginalFilename());
            targetLocation = this.profilePicture.resolve(fileName);
        } else if (type.equals("levelPicture")) {
            fileName = id + "-level-picture." + getFileExtension(file.getOriginalFilename());
            targetLocation = this.levelPicture.resolve(fileName);
        } else if (type.equals("levelMap")) {
            fileName = "map." + id + getFileExtension(file.getOriginalFilename());
            targetLocation = this.levelMap.resolve(fileName);
        } else return "";

        if (fileName.contains("..")) {
            return "Invalid Characters";
        }

        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

        return fileName;
    }

    public String getFileExtension(String fileName) {
        if (fileName == null) return null;

        String[] fileNameParts = fileName.split("\\.");

        return fileNameParts[fileNameParts.length - 1];
    }
}