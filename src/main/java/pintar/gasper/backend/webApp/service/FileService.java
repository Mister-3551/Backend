package pintar.gasper.backend.webApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    private final Path profilePicture;
    private final Path welcomePicture;
    private final Path levelPicture;
    private final Path tiles;
    private final Path tilesDimensions;
    private final Path tilesPictures70X70;
    private final Path levelMap;

    @Autowired
    public FileService(Environment environment) {
        this.profilePicture = Paths.get(environment.getProperty("app.file.upload-dir-profile-picture", "./files/pictures/profile-picture"));
        this.welcomePicture = Paths.get(environment.getProperty("app.file.upload-dir-welcome-picture", "./files/pictures/welcome-picture"));
        this.levelPicture = Paths.get(environment.getProperty("app.file.upload-dir-level-picture", "./files/pictures/level-picture"));
        this.tiles = Paths.get(environment.getProperty("app.file.upload-dir-tiles", "./files/tiles"));
        this.tilesDimensions = Paths.get(environment.getProperty("app.file.upload-dir-tiles-dimensions", "./files/tiles/tiles-dimensions"));
        this.tilesPictures70X70 = Paths.get(environment.getProperty("app.file.upload-dir-tiles-pictures-70X70", "./files/tiles/tiles-dimensions/70X70"));
        this.levelMap = Paths.get(environment.getProperty("app.file.upload-dir-level-map", "./files/level-map"));
    }

    public ResponseEntity<byte[]> getProfilePicture(String filename) throws Exception {
        byte[] image = Files.readAllBytes(Paths.get(profilePicture + "/" + filename));
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }

    public ResponseEntity<byte[]> getLevelPicture(String filename) throws Exception {
        byte[] image = Files.readAllBytes(Paths.get(levelPicture + "/" + filename));
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }

    public ResponseEntity<byte[]> getTilePicture70X70(String filename) throws Exception {
        byte[] image = Files.readAllBytes(Paths.get(tilesPictures70X70 + "/" + filename));
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }


    public ResponseEntity<byte[]> getLevelMap(String filename) throws Exception {
        byte[] image = Files.readAllBytes(Paths.get(levelMap + "/" + filename));

        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        return ResponseEntity.ok().headers(header).contentType(MediaType.APPLICATION_OCTET_STREAM).body(image);
    }
}