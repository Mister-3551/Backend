package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pintar.gasper.backend.webApp.entity.skins.SkinEntity;
import pintar.gasper.backend.webApp.service.SkinService;

import java.util.ArrayList;

@RestController
public class SkinController {

    private SkinService skinService;

    @Autowired
    public SkinController(SkinService skinService) {
        this.skinService = skinService;
    }

    @PostMapping(value = "/web-get-skins")
    public ArrayList<SkinEntity> getTiles(@RequestParam(name = "idUserOrUsername") String idUserOrUsername) {
        return skinService.getSkins(idUserOrUsername);
    }
}