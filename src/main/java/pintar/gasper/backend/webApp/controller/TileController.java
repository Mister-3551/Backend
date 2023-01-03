package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pintar.gasper.backend.webApp.entity.tiles.Tile;
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
    public ArrayList<Tile> getTiles() {
        return tileService.getTiles();
    }
}