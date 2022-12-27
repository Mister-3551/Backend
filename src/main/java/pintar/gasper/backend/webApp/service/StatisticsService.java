package pintar.gasper.backend.webApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pintar.gasper.backend.webApp.object.AppNavigation;
import pintar.gasper.backend.webApp.object.LeaderBoard;
import pintar.gasper.backend.webApp.object.PlayerStatistics;
import pintar.gasper.backend.webApp.repository.StatisticsRepository;

import java.util.ArrayList;

@Component
public class StatisticsService {

    private StatisticsRepository statisticsRepository;

    @Autowired
    public StatisticsService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    public PlayerStatistics getPlayerStatistics(String idUserOrUsername) {
        String[] list;
        if (idUserOrUsername.matches("-?\\d+")) list = statisticsRepository.getPlayerStatistics(idUserOrUsername);
        else list = statisticsRepository.getWantedPlayerStatistics(idUserOrUsername);
        return createStatistic(list);
    }

    public AppNavigation getPlayerBasicData(String idUser) {
        var list = statisticsRepository.getPlayerBasicData(idUser);
        AppNavigation appNavigation = new AppNavigation();
        for (String string : list) {
            var word = string.split(",");
            appNavigation = new AppNavigation(word[0], Integer.valueOf(word[1]));
        }
        return appNavigation;
    }

    public ArrayList<LeaderBoard> getLeaderBoardStatistics() {
        var list = statisticsRepository.getLeaderBoardStatistics();
        ArrayList<LeaderBoard> leaderBoard = new ArrayList();
        for (String string : list) {
            var word = string.split(",");
            leaderBoard.add(new LeaderBoard(Integer.parseInt(word[0]), word[1], word[2], Integer.parseInt(word[3]), Integer.parseInt(word[4])));
        }
        return leaderBoard;
    }

    private PlayerStatistics createStatistic(String[] list) {
        PlayerStatistics playerStats = new PlayerStatistics();
        for (String string : list) {
            var word = string.split(",");
            playerStats = new PlayerStatistics(word[0], Integer.parseInt(word[1]), Integer.parseInt(word[2]),
                    Integer.parseInt(word[3]), word[4], Integer.parseInt(word[5]), Integer.parseInt(word[6]),
                    Integer.parseInt(word[7]), Integer.parseInt(word[8]), Integer.parseInt(word[9]),
                    Integer.parseInt(word[10]), Float.parseFloat(word[11]));
        }
        return playerStats;
    }
}
