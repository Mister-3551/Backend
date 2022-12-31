package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
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
    public ResponseEntity<byte[]> getLevelPicture(@PathVariable("filename") String filename) throws Exception {
        return fileService.getLevelPicture(filename);
    }

    @GetMapping("/level-map/{filename}")
    public ResponseEntity<Resource> getLevelMap(@PathVariable("filename") String filename) throws Exception {
        return fileService.getLevelMap(filename);
    }
}