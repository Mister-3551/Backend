package pintar.gasper.backend.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pintar.gasper.backend.game.service.LevelService;
import pintar.gasper.backend.webApp.entity.levels.LevelsEntity;

import java.util.ArrayList;

@RestController
public class LevelsController {

    private LevelService service;

    @Autowired
    public LevelsController(LevelService service) {
        this.service = service;
    }

    @PostMapping("/get-levels")
    public ArrayList<LevelsEntity> getLevels(@RequestParam(name = "idUser") String idUser) {
        return service.getLevels(idUser);
    }
}