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

    private final Path fileStorageLocation;

    @Autowired
    public FileStorageService(Environment env) throws Exception {
        this.fileStorageLocation = Paths.get(env.getProperty("app.file.upload-dir", "./images/profile-pictures"))
                .toAbsolutePath().normalize();
        Files.createDirectories(fileStorageLocation);
    }

    public String storePicture(String idUser, MultipartFile profilePicture) throws Exception {

        String fileName = idUser + "-profile-picture." + getFileExtension(profilePicture.getOriginalFilename());

        if (fileName.contains("..")) {
            return "Invalid Characters";
        }

        Path targetLocation = fileStorageLocation.resolve(fileName);
        Files.copy(profilePicture.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

        return fileName;
    }

    public String getFileExtension(String fileName) {
        if (fileName == null) return null;

        String[] fileNameParts = fileName.split("\\.");

        return fileNameParts[fileNameParts.length - 1];
    }
}