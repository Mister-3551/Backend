package pintar.gasper.backend.webApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pintar.gasper.backend.webApp.entity.leaderboard.LeaderBoardEntity;
import pintar.gasper.backend.webApp.repository.LeaderBoardRepository;

import java.util.ArrayList;

@Component
public class LeaderBoardService {

    private LeaderBoardRepository leaderBoardRepository;

    @Autowired
    public LeaderBoardService(LeaderBoardRepository leaderBoardRepository) {
        this.leaderBoardRepository = leaderBoardRepository;
    }

    public ArrayList<LeaderBoardEntity> getLeaderBoardStatistics() {
        return leaderBoardRepository.getLeaderBoardStatistics();
    }
}