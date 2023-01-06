package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/skin-picture/{character}/{type}/{filename}")
    public ResponseEntity<byte[]> getSkinPicture(@PathVariable("character") String character, @PathVariable("type") String type, @PathVariable("filename") String filename) throws Exception {
        return fileService.getSkinPicture(character, type, filename);
    }

    @GetMapping("/level-map/{filename}")
    public ResponseEntity<byte[]> getLevelMaps(@PathVariable("filename") String filename) throws Exception {
        return fileService.getLevelMaps(filename);
    }
}