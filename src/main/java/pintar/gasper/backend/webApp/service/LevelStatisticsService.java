package pintar.gasper.backend.webApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pintar.gasper.backend.game.repository.LevelRepository;
import pintar.gasper.backend.webApp.entity.levels.LevelsEntity;
import pintar.gasper.backend.webApp.entity.levels.LevelsStatisticsEntity;
import pintar.gasper.backend.webApp.repository.LevelsStatisticsRepository;

import java.util.ArrayList;

@Component
public class LevelStatisticsService {

    private LevelsStatisticsRepository levelsStatisticsRepository;
    private LevelRepository levelRepository;

    @Autowired
    public LevelStatisticsService(LevelsStatisticsRepository levelsStatisticsRepository, LevelRepository levelRepository) {
        this.levelsStatisticsRepository = levelsStatisticsRepository;
        this.levelRepository = levelRepository;
    }

    public ArrayList<LevelsEntity> getLevelsStatistics(String idUserOrUsername) {
        return levelRepository.getLevels(idUserOrUsername);
    }

    public ArrayList<LevelsStatisticsEntity> getLevelsStatisticsData(String idUserOrUsername, String mapName) {
        return levelsStatisticsRepository.getLevelsStatistics(idUserOrUsername, mapName);
    }

    public String getLevelName(String mapName) {
        return levelsStatisticsRepository.getLevelName(mapName);
    }
}