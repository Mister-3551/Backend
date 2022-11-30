package pintar.gasper.backend.webApp.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pintar.gasper.backend.webApp.repository.WebLoginRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class WebLoginService {

    private WebLoginRepository webLoginRepository;

    @Autowired
    public WebLoginService(WebLoginRepository webLoginRepository) {
        this.webLoginRepository = webLoginRepository;
    }

    public String webAuthentication(String usernameEmail, String password) {
        var user = webLoginRepository.findByUsernameOrEmailAndPassword(usernameEmail, password);
        var accessToken = "";
        if (user != null) {
            accessToken = generateToken(user.getId(), user.getName(), user.getUsername(), user.getEmail());
            //if (!user.getUsername().isEmpty()) tokensRepository.setGameToken(accessToken, user.getId());
        }
        return accessToken;
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