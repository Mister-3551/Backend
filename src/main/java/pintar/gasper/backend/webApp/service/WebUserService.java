package pintar.gasper.backend.webApp.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import pintar.gasper.backend.webApp.object.SearchUser;
import pintar.gasper.backend.webApp.object.User;
import pintar.gasper.backend.webApp.object.UserAccount;
import pintar.gasper.backend.webApp.repository.WebUserRepository;
import pintar.gasper.backend.webApp.service.uploadfile.FileStorageService;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Component
public class WebUserService {

    private WebUserRepository webUserRepository;
    private FileStorageService fileStorageService;

    @Autowired
    public WebUserService(WebUserRepository webUserRepository, FileStorageService fileStorageService) {
        this.webUserRepository = webUserRepository;
        this.fileStorageService = fileStorageService;
    }

    public String webAuthentication(String usernameEmail, String password) {
        var list = webUserRepository.findUser(usernameEmail, password);
        var accessToken = "";
        User user = new User();
        for (String string : list) {
            var word = string.split(",");
            user = new User(Long.parseLong(word[0]), word[1], word[2], word[3], word[4]);
        }
        if (user.getId() != null) accessToken = generateToken(user.getId(), user.getName(), user.getUsername(), user.getEmail(), user.getRole());
        return accessToken;
    }

    public UserAccount getUserAccountData(String idUser) {
        var list = webUserRepository.getUserAccountData(idUser);
        UserAccount userAccount = new UserAccount();
        for (String string : list) {
            var word = string.split(",");
            userAccount = new UserAccount(word[0], word[1], word[2]);
        }
        return userAccount;
    }

    public ArrayList<SearchUser> getUsersBySearch(String username) {
        var list = webUserRepository.getUsersBySearch(username);
        var users = new ArrayList<SearchUser>();
        for (String string : list) {
            var word = string.split(",");
            users.add(new SearchUser(Long.parseLong(word[0]), word[1], Integer.parseInt(word[2]), word[3]));
        }
        return users;
    }

    public String updateUserAccountData(String idUser, String fullName, MultipartFile profileImage) throws Exception {
        if (profileImage != null) {
            if (profileImage.getSize() > 2097152L) return "Image size is more than 2 MB";
            if (profileImage.getOriginalFilename().contains("..")) return "Invalid Characters";
            if (!fileStorageService.getFileExtension(profileImage.getOriginalFilename()).equals("jpg")) return "Wrong file format";
            String fileName = fileStorageService.storePicture(idUser, profileImage, "profilePicture");
            if (webUserRepository.updateProfileWithPicture(idUser, fullName, fileName) == 0) return "Couldn't update profile data";
        }
        if (webUserRepository.updateProfileWithoutPicture(idUser, fullName) == 0) return "Couldn't update profile data";
        return "The account has been updated";
    }

    public ResponseEntity<byte[]> getImage(String filename) throws Exception {
        byte[] image = Files.readAllBytes(Paths.get("./images/profile-picture/" + filename));
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }

    private String generateToken(Long id, String name, String username, String email, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", id);
        claims.put("name", name);
        claims.put("username", username);
        claims.put("email", email);
        claims.put("role", role);

        String accessToken = Jwts.builder().setClaims(claims).setSubject("Authentication").setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 1000))
                .signWith(SignatureAlgorithm.HS512, "secret").compact();
        return accessToken;
    }
}