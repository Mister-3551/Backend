package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pintar.gasper.backend.webApp.entity.tiles.TileEntity;
import pintar.gasper.backend.webApp.service.TileService;

import java.util.ArrayList;

@RestController
public class TileController {

    private TileService tileService;

    @Autowired
    public TileController(TileService tileService) {
        this.tileService = tileService;
    }

    @PostMapping(value = "/web-get-tiles")
    public ArrayList<TileEntity> getTiles() {
        return tileService.getTiles();
    }
}