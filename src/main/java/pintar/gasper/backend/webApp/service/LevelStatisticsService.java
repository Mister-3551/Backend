package pintar.gasper.backend.webApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pintar.gasper.backend.game.object.Level;
import pintar.gasper.backend.game.repository.LevelRepository;
import pintar.gasper.backend.webApp.object.LevelStatistics;
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

    public ArrayList<Level> getLevelsStatistics(String gameToken) {
        var list = levelRepository.getLevels(gameToken);
        ArrayList<Level> levels = new ArrayList();
        for (String string : list) {
            var word = string.split(",");
            levels.add(new Level(word[0], word[1], Integer.valueOf(word[2])));
        }
        return levels;
    }

    public ArrayList<LevelStatistics> getLevelsStatisticsData(String idUser, String mapName) {
        var list = levelsStatisticsRepository.getLevelsStatistics(idUser, mapName);
        ArrayList<LevelStatistics> levelStatistics = new ArrayList();
        for (String string : list) {
            var word = string.split(",");
            levelStatistics.add(new LevelStatistics(word[0], word[1], Integer.parseInt(word[2]), Integer.parseInt(word[3]), Integer.parseInt(word[4])));
        }
        return levelStatistics;
    }
}
