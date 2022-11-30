package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pintar.gasper.backend.game.object.Level;
import pintar.gasper.backend.webApp.object.LevelStatistics;
import pintar.gasper.backend.webApp.service.LevelStatisticsService;

import java.util.ArrayList;

@RestController
public class LevelStatisticsController {

    private LevelStatisticsService levelStatisticsService;

    @Autowired
    public LevelStatisticsController(LevelStatisticsService levelStatisticsService) {
        this.levelStatisticsService = levelStatisticsService;
    }

    @PostMapping("/web-get-levels-statistics")
    public ArrayList<Level> getLevelsStatistics(@RequestParam(name = "gameToken") String gameToken) {
        return levelStatisticsService.getLevelsStatistics(gameToken);
    }

    @PostMapping("/web-get-levels-statistics-data")
    public ArrayList<LevelStatistics> getLevelsStatisticsData(@RequestParam(name = "idUser") String idUser, @RequestParam(name = "mapName") String mapName) {
        return levelStatisticsService.getLevelsStatisticsData(idUser, mapName);
    }
}