package pintar.gasper.backend.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pintar.gasper.backend.game.object.Setting;
import pintar.gasper.backend.game.service.SettingsService;

@RestController
public class SettingsController {

    private SettingsService service;

    @Autowired
    public SettingsController(SettingsService service) {
        this.service = service;
    }

    @PostMapping("/get-settings")
    public Setting getLevels(@RequestParam(name = "gameToken") String gameToken) {
        return service.getSettings(gameToken);
    }
}