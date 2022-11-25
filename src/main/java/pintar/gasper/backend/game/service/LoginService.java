package pintar.gasper.backend.game.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pintar.gasper.backend.game.object.Message;
import pintar.gasper.backend.game.object.User;
import pintar.gasper.backend.game.repository.LoginRepository;
import pintar.gasper.backend.game.repository.TokensRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class LoginService {

    private LoginRepository loginRepository;
    private TokensRepository tokensRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository, TokensRepository tokensRepository) {
        this.loginRepository = loginRepository;
        this.tokensRepository = tokensRepository;
    }

    public String authentication(String username, String password) {
        var user = loginRepository.findByUsernameAndPassword(username, password);
        var accessToken = "";
        if (user != null) {
            accessToken = generateToken(user.getName(), user.getUsername(), String.valueOf(user.getRank()), password);
            if (!user.getUsername().isEmpty()) tokensRepository.setGameToken(accessToken, user.getId());
        }
        return accessToken;
    }

    public String signOut(String gameToken) {
        int integer = tokensRepository.signOut(gameToken);
        return integer == 1 ? "true" : "false";
    }

    public Message forgotPassword(String email) {
        return new Message.Builder().title("Forgot Password").description(email).code(200).build();
    }

    private String generateToken(String name, String username, String rank, String password) {
        Map<String, Object> claims = new HashMap<>();
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
