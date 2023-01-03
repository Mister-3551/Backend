package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pintar.gasper.backend.webApp.service.FileService;

@RestController
public class FileController {

    private FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/profile-picture/{filename}")
    public ResponseEntity<byte[]> getProfilePicture(@PathVariable("filename") String filename) throws Exception {
        return fileService.getProfilePicture(filename);
    }

    @GetMapping("/profile-picture-update/{filename}")
    public ResponseEntity<byte[]> getProfilePictureUpdate(@PathVariable("filename") String filename) throws Exception {
        return fileService.getProfilePicture(filename);
    }

    @GetMapping("/level-picture/{filename}")
    public ResponseEntity<byte[]> getLevelPictures(@PathVariable("filename") String filename) throws Exception {
        return fileService.getLevelPictures(filename);
    }

    @GetMapping("/tile-picture-70X70/{filename}")
    public ResponseEntity<byte[]> getTilePicture70X70(@PathVariable("filename") String filename) throws Exception {
        return fileService.getTilePicture70X70(filename);
    }

    @GetMapping("/skin-picture/{filename}")
    public ResponseEntity<byte[]> getSkinPicture(@PathVariable("filename") String filename) throws Exception {
        return fileService.getSkinPicture(filename);
    }

    @GetMapping("/level-map/{filename}")
    public ResponseEntity<byte[]> getLevelMaps(@PathVariable("filename") String filename) throws Exception {
        return fileService.getLevelMaps(filename);
    }
}