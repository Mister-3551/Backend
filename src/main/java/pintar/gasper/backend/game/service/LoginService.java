package pintar.gasper.backend.game.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pintar.gasper.backend.game.object.Message;
import pintar.gasper.backend.game.object.User;
import pintar.gasper.backend.game.repository.LoginRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoginService {

    private LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public String authentication(String username, String password) {
        User user = null;
        var accessToken = "";
        if (user != null) {
            accessToken = generateToken(user.getId(), user.getName(), user.getUsername(), String.valueOf(user.getRank()), password);
            //if (!user.getUsername().isEmpty()) tokensRepository.setGameToken(accessToken, user.getId());
        }
        return accessToken;
    }

    public String signOut(String gameToken) {
        //int integer = tokensRepository.signOut(gameToken);
        //return integer == 1 ? "true" : "false";
        return "false";
    }

    public Message forgotPassword(String email) {
        return new Message.Builder().title("Forgot Password").description(email).code(200).build();
    }

    private String generateToken(Long userId, String name, String username, String rank, String password) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("idUser", String.valueOf(userId));
        claims.put("name", name);
        claims.put("username", username);
        claims.put("rank", rank);
        claims.put("password", password);

        String accessToken = Jwts.builder().setClaims(claims).setSubject("Authentication").setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 1000))
                .signWith(SignatureAlgorithm.HS512, "secret").compact();
        return accessToken;
    }
}
