package pintar.gasper.backend.webApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pintar.gasper.backend.webApp.entity.skins.SkinEntity;
import pintar.gasper.backend.webApp.repository.SkinRepository;

import java.util.ArrayList;

@Component
public class SkinService {

    private SkinRepository skinRepository;

    @Autowired
    public SkinService(SkinRepository skinRepository) {
        this.skinRepository = skinRepository;
    }

    public ArrayList<SkinEntity> getSkins(String idUserOrUsername) {
        return skinRepository.getSkins(idUserOrUsername);
    }
}