package pintar.gasper.backend.game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pintar.gasper.backend.game.object.Level;
import pintar.gasper.backend.game.repository.LevelRepository;

import java.util.ArrayList;

@Component
public class LevelService {

    private LevelRepository repository;

    @Autowired
    public LevelService(LevelRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Level> getLevels(String gameToken) {
        var list = repository.getLevels(gameToken);
        ArrayList<Level> levels = new ArrayList();
        for (String string : list) {
            var word = string.split(",");
            levels.add(new Level(word[0], word[1], Integer.valueOf(word[2])));
        }
        return levels;
    }
}