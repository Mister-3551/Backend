package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pintar.gasper.backend.webApp.object.AppNavigation;
import pintar.gasper.backend.webApp.object.LeaderBoard;
import pintar.gasper.backend.webApp.object.PlayerStatistics;
import pintar.gasper.backend.webApp.service.StatisticsService;

import java.util.ArrayList;

@RestController
public class StatisticsController {

    private StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @PostMapping("/web-get-player-statistics")
    public PlayerStatistics getPlayerStatistics(@RequestParam(name = "idUserOrUsername") String idUserOrUsername) {
        return statisticsService.getPlayerStatistics(idUserOrUsername);
    }

    @PostMapping("/web-get-player-basic-data")
    public AppNavigation getPlayerBasicData(@RequestParam(name = "idUser") String idUser) {
        return statisticsService.getPlayerBasicData(idUser);
    }

    @PostMapping("/web-get-leader-board-statistics")
    public ArrayList<LeaderBoard> getLeaderBoardStatistics() {
        return statisticsService.getLeaderBoardStatistics();
    }
}