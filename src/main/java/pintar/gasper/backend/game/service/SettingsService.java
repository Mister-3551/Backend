package pintar.gasper.backend.game.service;

import org.springframework.stereotype.Component;
import pintar.gasper.backend.game.entity.Settings;
import pintar.gasper.backend.game.object.Level;
import pintar.gasper.backend.game.object.Setting;
import pintar.gasper.backend.game.repository.SettingsRepository;

import java.util.ArrayList;

@Component
public class SettingsService {

    private SettingsRepository repository;

    public SettingsService(SettingsRepository repository) {
        this.repository = repository;
    }

    public Setting getSettings(String gameToken) {
        var list =  repository.getSettings(gameToken);
        Setting settings = new Setting();
        for (String string : list) {
            var word = string.split(",");
            settings = new Setting(word[0], word[1], word[2], word[3], word[4], word[5], word[6]);
        }
        return settings;
    }
}