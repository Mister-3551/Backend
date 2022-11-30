package pintar.gasper.backend.webApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pintar.gasper.backend.game.object.Level;
import pintar.gasper.backend.webApp.object.PlayerStatistics;
import pintar.gasper.backend.webApp.repository.PlayerStatsRepository;

import java.util.ArrayList;

@Component
public class PlayerStatsService {

    private PlayerStatsRepository playerStatsRepository;

    @Autowired
    public PlayerStatsService(PlayerStatsRepository playerStatsRepository) {
        this.playerStatsRepository = playerStatsRepository;
    }

    public ArrayList<PlayerStatistics> getPlayerStats(String webToken) {
        var list = playerStatsRepository.getPlayerStatistics(webToken);
        ArrayList<PlayerStatistics> playerStats = new ArrayList();
        for (String string : list) {
            var word = string.split(",");
            playerStats.add(new PlayerStatistics(Integer.valueOf(word[0]), Integer.valueOf(word[1]), Integer.valueOf(word[2]), Integer.valueOf(word[3]),Integer.valueOf(word[4]),Integer.valueOf(word[5])));
        }
        return playerStats;
    }
}
