package pintar.gasper.backend.webApp.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pintar.gasper.backend.webApp.object.SearchUser;
import pintar.gasper.backend.webApp.object.User;
import pintar.gasper.backend.webApp.object.UserAccount;
import pintar.gasper.backend.webApp.repository.WebUserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class WebUserService {

    private WebUserRepository webUserRepository;

    @Autowired
    public WebUserService(WebUserRepository webUserRepository) {
        this.webUserRepository = webUserRepository;
    }

    public String webAuthentication(String usernameEmail, String password) {
        var list = webUserRepository.findUser(usernameEmail, password);
        var accessToken = "";
        User user = new User();
        for (String string : list) {
            var word = string.split(",");
            user = new User(Long.parseLong(word[0]), word[1], word[2], word[3]);
        }
        if (user.getId() != null) accessToken = generateToken(user.getId(), user.getName(), user.getUsername(), user.getEmail());
        return accessToken;
    }

    public UserAccount getUserAccountData(String idUser) {
        var list = webUserRepository.getUserAccountData(idUser);
        UserAccount userAccount = new UserAccount();
        for (String string : list) {
            var word = string.split(",");
            userAccount = new UserAccount(word[0], word[1]);
        }
        return userAccount;
    }

    public ArrayList<SearchUser> getUsersBySearch(String username) {
        var list = webUserRepository.getUsersBySearch(username);
        var users = new ArrayList<SearchUser>();
        for (String string : list) {
            var word = string.split(",");
            users.add(new SearchUser(Long.parseLong(word[0]), word[1], Integer.parseInt(word[2])));
        }
        return users;
    }

    private String generateToken(Long id, String name, String username, String email) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", id);
        claims.put("name", name);
        claims.put("username", username);
        claims.put("email", email);

        String accessToken = Jwts.builder().setClaims(claims).setSubject("Authentication").setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 1000))
                .signWith(SignatureAlgorithm.HS512, "secret").compact();
        return accessToken;
    }
}