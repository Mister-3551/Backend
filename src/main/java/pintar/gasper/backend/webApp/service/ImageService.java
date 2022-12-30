package pintar.gasper.backend.webApp.service;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class ImageService {

    public ResponseEntity<byte[]> getImage(String filename) throws Exception {
        byte[] image = Files.readAllBytes(Paths.get("./images/profile-picture/" + filename));
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }
}