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

    private final Path profilePictures;
    private final Path welcomePicture;
    private final Path levelPictures;
    private final Path tiles;
    private final Path tilesDimensions;
    private final Path tilesPictures70X70;
    private final Path levelMaps;

    @Autowired
    public FileStorageService(Environment environment) throws Exception {
        this.profilePictures = Paths.get(environment.getProperty("app.file.upload-dir-profile-pictures", "./files/pictures/profile-pictures")).toAbsolutePath().normalize();
        this.welcomePicture = Paths.get(environment.getProperty("app.file.upload-dir-welcome-picture", "./files/pictures/welcome-picture")).toAbsolutePath().normalize();
        this.levelPictures = Paths.get(environment.getProperty("app.file.upload-dir-level-pictures", "./files/pictures/level-pictures")).toAbsolutePath().normalize();
        this.tiles = Paths.get(environment.getProperty("app.file.upload-dir-tiles", "./files/tiles")).toAbsolutePath().normalize();
        this.tilesDimensions = Paths.get(environment.getProperty("app.file.upload-dir-tiles-dimensions", "./files/tiles/tiles-dimensions")).toAbsolutePath().normalize();
        this.tilesPictures70X70 = Paths.get(environment.getProperty("app.file.upload-dir-tiles-pictures-70X70", "./files/tiles/tiles-dimensions/70X70")).toAbsolutePath().normalize();
        this.levelMaps = Paths.get(environment.getProperty("app.file.upload-dir-level-maps", "./files/level-maps")).toAbsolutePath().normalize();

        Files.createDirectories(profilePictures);
        Files.createDirectories(levelPictures);
        Files.createDirectories(welcomePicture);
        Files.createDirectories(tiles);
        Files.createDirectories(tilesDimensions);
        Files.createDirectories(tilesPictures70X70);
        Files.createDirectories(levelMaps);
    }

    public String storePicture(String id, MultipartFile file, String type) throws Exception {
        String fileName;
        Path targetLocation;

        switch (type) {
            case "profilePicture" -> {
                fileName = id + "-profile-picture." + getFileExtension(file.getOriginalFilename());
                targetLocation = this.profilePictures.resolve(fileName);
            }
            case "levelPicture" -> {
                fileName = "level" + id + "." + getFileExtension(file.getOriginalFilename());
                targetLocation = this.levelPictures.resolve(fileName);
            }
            case "levelMap" -> {
                fileName = "map" + id + "." + getFileExtension(file.getOriginalFilename());
                targetLocation = this.levelMaps.resolve(fileName);
            }
            case "tilesPictures" -> {
                fileName = file.getOriginalFilename() + id + "." + getFileExtension(file.getOriginalFilename());
                targetLocation = this.levelMaps.resolve(fileName);
            }
            default -> {
                return "";
            }
        }

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