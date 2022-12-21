package pintar.gasper.backend.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pintar.gasper.backend.game.object.Unit;
import pintar.gasper.backend.game.service.ShopService;

import java.util.ArrayList;

@RestController
public class ShopController {

    private ShopService service;

    @Autowired
    public ShopController(ShopService service) {
        this.service = service;
    }

    @RequestMapping(value = "/get-units")
    public ArrayList<Unit> getUnits() {
        return service.getUnits();
    }
}
