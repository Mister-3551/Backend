package pintar.gasper.backend.webApp.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import pintar.gasper.backend.webApp.entity.account.AccountEntity;
import pintar.gasper.backend.webApp.repository.AccountRepository;
import pintar.gasper.backend.webApp.service.uploadfile.FileStorageService;
import java.util.*;

@Component
public class AccountService {

    private AccountRepository accountRepository;
    private FileStorageService fileStorageService;

    @Autowired
    public AccountService(AccountRepository accountRepository, FileStorageService fileStorageService) {
        this.accountRepository = accountRepository;
        this.fileStorageService = fileStorageService;
    }

    public String webAuthentication(String usernameEmail, String password) {
        AccountEntity user = accountRepository.findUser(usernameEmail, password);
        var accessToken = "";
        if (user != null) accessToken = generateToken(user.getId(), user.getRole());
        return accessToken;
    }

    public AccountEntity getUserAccountData(String idUser) {
        return accountRepository.getUserAccountData(idUser);
    }

    public String updateUserAccountData(String idUser, String fullName, MultipartFile profilePicture) throws Exception {
        if (profilePicture != null) {
            if (profilePicture.getSize() > 2097152L) return "Image size is more than 2 MB";
            if (profilePicture.getOriginalFilename().contains("..")) return "Invalid Characters";
            if (!fileStorageService.getFileExtension(profilePicture.getOriginalFilename()).equals("jpg"))
                return "Wrong file format";
            String fileName = fileStorageService.storePicture(idUser, profilePicture, "profilePicture");
               if (accountRepository.updateProfileWithPicture(idUser, fullName, fileName) == 0) return "Couldn't update profile data";
        }
        if (accountRepository.updateProfileWithoutPicture(idUser, fullName) == 0) return "Couldn't update profile data";
        return "The account has been updated";
    }

    private String generateToken(Long id, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", id);
        claims.put("role", role);

        String accessToken = Jwts.builder().setClaims(claims).setSubject("Authentication").setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 1000))
                .signWith(SignatureAlgorithm.HS512, "secret").compact();
        return accessToken;
    }
}