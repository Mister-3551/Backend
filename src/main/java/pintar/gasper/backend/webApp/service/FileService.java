package pintar.gasper.backend.webApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    private final Path profilePictures;
    private final Path welcomePicture;
    private final Path levelPictures;
    private final Path tilesPictures70X70;
    private final Path levelMaps;

    @Autowired
    public FileService(Environment environment) {
        this.profilePictures = Paths.get(environment.getProperty("app.file.upload-dir-profile-pictures", "./files/pictures/profile-pictures")).toAbsolutePath().normalize();
        this.welcomePicture = Paths.get(environment.getProperty("app.file.upload-dir-welcome-picture", "./files/pictures/welcome-picture")).toAbsolutePath().normalize();
        this.levelPictures = Paths.get(environment.getProperty("app.file.upload-dir-level-pictures", "./files/pictures/level-pictures")).toAbsolutePath().normalize();
        this.tilesPictures70X70 = Paths.get(environment.getProperty("app.file.upload-dir-tiles-pictures-70X70", "./files/tiles/tiles-dimensions/70X70")).toAbsolutePath().normalize();
        this.levelMaps = Paths.get(environment.getProperty("app.file.upload-dir-level-maps", "./files/level-maps")).toAbsolutePath().normalize();
    }

    public ResponseEntity<byte[]> getProfilePicture(String filename) throws Exception {
        byte[] image = Files.readAllBytes(Paths.get(profilePictures + "/" + filename));
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }

    public ResponseEntity<byte[]> getLevelPictures(String filename) throws Exception {
        byte[] image = Files.readAllBytes(Paths.get(levelPictures + "/" + filename));
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }

    public ResponseEntity<byte[]> getTilePicture70X70(String filename) throws Exception {
        byte[] image = Files.readAllBytes(Paths.get(tilesPictures70X70 + "/" + filename));
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }


    public ResponseEntity<byte[]> getLevelMaps(String filename) throws Exception {
        byte[] image = Files.readAllBytes(Paths.get(levelMaps + "/" + filename));

        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        return ResponseEntity.ok().headers(header).contentType(MediaType.APPLICATION_OCTET_STREAM).body(image);
    }
}