package pintar.gasper.backend.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pintar.gasper.backend.game.object.Level;
import pintar.gasper.backend.game.service.LevelService;

import java.util.ArrayList;

@RestController
public class LevelsController {

    private LevelService service;

    @Autowired
    public LevelsController(LevelService service) {
        this.service = service;
    }

    @PostMapping("/get-levels")
    public ArrayList<Level> getLevels(@RequestParam(name = "gameToken") String gameToken) {
        return service.getLevels(gameToken);
    }
}