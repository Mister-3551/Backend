package pintar.gasper.backend.game.service;

import org.springframework.stereotype.Component;
import pintar.gasper.backend.game.entity.SettingsEntity;
import pintar.gasper.backend.game.repository.SettingsRepository;

@Component
public class SettingsService {

    private SettingsRepository settingsRepository;

    public SettingsService(SettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
    }

    public SettingsEntity getSettings(Long idUser) {
        return settingsRepository.getSettings(idUser);
    }
}