package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pintar.gasper.backend.webApp.object.LevelStatistics;
import pintar.gasper.backend.webApp.object.PlayerStatistics;
import pintar.gasper.backend.webApp.service.PlayerStatsService;

import java.util.ArrayList;

@RestController
public class PlayerStatsController {

    private PlayerStatsService playerStatsService;

    @Autowired
    public PlayerStatsController(PlayerStatsService playerStatsService) {
        this.playerStatsService = playerStatsService;
    }

    @PostMapping("/web-get-player-stats")
    public ArrayList<PlayerStatistics> getPlayerStats(@RequestParam(name = "webToken") String webToken) {
        return playerStatsService.getPlayerStats(webToken);
    }
}