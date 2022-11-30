package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pintar.gasper.backend.webApp.service.PlayerStatsService;

@RestController
public class PlayerStats {

    private PlayerStatsService playerStatsService;

    @Autowired
    public PlayerStats(PlayerStatsService playerStatsService) {
        this.playerStatsService = playerStatsService;
    }
}
