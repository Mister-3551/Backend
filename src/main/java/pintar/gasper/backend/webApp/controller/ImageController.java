package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pintar.gasper.backend.webApp.service.ImageService;

@RestController
public class ImageController {

    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/profile-images/{filename}")
    public ResponseEntity<byte[]> getImage(@PathVariable("filename") String filename) throws Exception {
        return imageService.getImage(filename);
    }

    @GetMapping("/profile-images-update/{filename}")
    public ResponseEntity<byte[]> getImageUpdate(@PathVariable("filename") String filename) throws Exception {
        return imageService.getImage(filename);
    }
}