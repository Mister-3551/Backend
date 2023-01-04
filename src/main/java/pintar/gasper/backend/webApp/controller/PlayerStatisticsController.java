package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pintar.gasper.backend.webApp.entity.playerstatistics.PlayerStatisticsEntity;
import pintar.gasper.backend.webApp.entity.admin.AppNavigation;
import pintar.gasper.backend.webApp.service.PlayerStatisticsService;

@RestController
public class PlayerStatisticsController {

    private PlayerStatisticsService playerStatisticsService;

    @Autowired
    public PlayerStatisticsController(PlayerStatisticsService playerStatisticsService) {
        this.playerStatisticsService = playerStatisticsService;
    }

    @PostMapping("/web-get-player-statistics")
    public PlayerStatisticsEntity getPlayerStatistics(@RequestParam(name = "idUserOrUsername") String idUserOrUsername) {
        return playerStatisticsService.getPlayerStatistics(idUserOrUsername);
    }

    @PostMapping("/web-get-player-basic-data")
    public AppNavigation getPlayerBasicData(@RequestParam(name = "idUser") Long idUser) {
        return playerStatisticsService.getPlayerBasicData(idUser);
    }
}