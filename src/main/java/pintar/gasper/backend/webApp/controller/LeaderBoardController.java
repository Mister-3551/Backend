package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pintar.gasper.backend.webApp.entity.leaderboard.LeaderBoardEntity;
import pintar.gasper.backend.webApp.service.LeaderBoardService;

import java.util.ArrayList;

@RestController
public class LeaderBoardController {

    private LeaderBoardService leaderBoardService;

    @Autowired
    public LeaderBoardController(LeaderBoardService leaderBoardService) {
        this.leaderBoardService = leaderBoardService;
    }

    @PostMapping("/web-get-leader-board-statistics")
    public ArrayList<LeaderBoardEntity> getLeaderBoardStatistics() {
        return leaderBoardService.getLeaderBoardStatistics();
    }
}