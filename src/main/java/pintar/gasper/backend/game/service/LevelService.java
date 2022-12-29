package pintar.gasper.backend.game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pintar.gasper.backend.game.repository.LevelRepository;
import pintar.gasper.backend.webApp.entity.levels.LevelsEntity;

import java.util.ArrayList;

@Component
public class LevelService {

    private LevelRepository levelRepository;

    @Autowired
    public LevelService(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    public ArrayList<LevelsEntity> getLevels(String idUser) {
        return levelRepository.getLevels(idUser);
    }
}