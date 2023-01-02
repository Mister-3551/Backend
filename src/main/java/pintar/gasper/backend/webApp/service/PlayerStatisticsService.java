package pintar.gasper.backend.webApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pintar.gasper.backend.webApp.entity.playerstatistics.PlayerStatistics;
import pintar.gasper.backend.webApp.entity.admin.object.AppNavigation;
import pintar.gasper.backend.webApp.repository.PlayerStatisticsRepository;

@Component
public class PlayerStatisticsService {

    private PlayerStatisticsRepository playerStatisticsRepository;

    @Autowired
    public PlayerStatisticsService(PlayerStatisticsRepository playerStatisticsRepository) {
        this.playerStatisticsRepository = playerStatisticsRepository;
    }

    public PlayerStatistics getPlayerStatistics(String idUserOrUsername) {
        return playerStatisticsRepository.getPlayerStatistics(idUserOrUsername);
    }

    public AppNavigation getPlayerBasicData(Long idUser) {
        var list = playerStatisticsRepository.getPlayerBasicData(idUser);
        AppNavigation appNavigation = new AppNavigation();
        for (String string : list) {
            var word = string.split(",");
            appNavigation = new AppNavigation(word[0], Integer.valueOf(word[1]), Integer.valueOf(word[2]));
        }
        return appNavigation;
    }
}