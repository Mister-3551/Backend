package pintar.gasper.backend.game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pintar.gasper.backend.game.object.Unit;
import pintar.gasper.backend.game.repository.ShopRepository;

import java.util.ArrayList;

@Component
public class ShopService {

    private ShopRepository repository;

    @Autowired
    public ShopService(ShopRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Unit> getUnits() {
        var list = repository.getUnits();
        ArrayList<Unit> units = new ArrayList();
        for (String string : list) {
            var word = string.split(",");
            units.add(new Unit(word[0], word[1]));
        }
        return units;
    }
}