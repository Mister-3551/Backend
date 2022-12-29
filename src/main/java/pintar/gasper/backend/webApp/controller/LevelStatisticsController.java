package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pintar.gasper.backend.webApp.entity.levels.LevelsEntity;
import pintar.gasper.backend.webApp.entity.levels.LevelsStatisticsEntity;
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
    public ArrayList<LevelsEntity> getLevelsStatistics(@RequestParam(name = "idUserOrUsername") String idUserOrUsername) {
        return levelStatisticsService.getLevelsStatistics(idUserOrUsername);
    }

    @PostMapping("/web-get-levels-statistics-data")
    public ArrayList<LevelsStatisticsEntity> getLevelsStatisticsData(@RequestParam(name = "idUserOrUsername") String idUserOrUsername, @RequestParam(name = "mapName") String mapName) {
        return levelStatisticsService.getLevelsStatisticsData(idUserOrUsername, mapName);
    }

    @PostMapping("/web-get-levels-statistics-data-level-name")
    public String getLevelName(@RequestParam(name = "mapName") String mapName) {
        return levelStatisticsService.getLevelName(mapName);
    }
}