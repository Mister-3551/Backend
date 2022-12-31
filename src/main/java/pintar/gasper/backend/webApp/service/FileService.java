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

    private final Path levelMap;

    @Autowired
    public FileService(Environment environment) {
        this.levelMap= Paths.get(environment.getProperty("app.file.upload-dir-level-map", "./images/level-map"));
    }

    public ResponseEntity<byte[]> getProfilePicture(String filename) throws Exception {
        byte[] image = Files.readAllBytes(Paths.get("./images/profile-picture/" + filename));
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }

    public ResponseEntity<byte[]> getLevelPicture(String filename) throws Exception {
        byte[] image = Files.readAllBytes(Paths.get("./images/level-picture/" + filename));
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }

    public ResponseEntity<Resource> getLevelMap(String filename) throws Exception {
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(Paths.get("./images/level-map/" + filename)));

        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        return ResponseEntity.ok()
                .headers(header)
                .contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
    }
}