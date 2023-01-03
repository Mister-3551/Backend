package pintar.gasper.backend.webApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pintar.gasper.backend.webApp.entity.tiles.Tile;
import pintar.gasper.backend.webApp.repository.TileRepository;

import java.util.ArrayList;

@Component
public class TileService {

    private TileRepository tileRepository;

    @Autowired
    public TileService(TileRepository tileRepository) {
        this.tileRepository = tileRepository;
    }

    public ArrayList<Tile> getTiles() {
        return tileRepository.getTiles();
    }
}