package pintar.gasper.backend.game.object;

public class Unit {

    private String name;
    private String healthPoints;

    public Unit(String name, String healthPoints) {
        this.name = name;
        this.healthPoints = healthPoints;
    }

    public String getName() {
        return name;
    }

    public String getHealthPoints() {
        return healthPoints;
    }
}