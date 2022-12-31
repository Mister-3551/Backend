package pintar.gasper.backend.webApp.object;

public class AppNavigation {

    private String username;
    private int rank;
    private int currentLevel;

    public AppNavigation() {}

    public AppNavigation(String username, int rank, int currentLevel) {
        this.username = username;
        this.rank = rank;
        this.currentLevel = currentLevel;
    }

    public String getUsername() {
        return username;
    }

    public int getRank() {
        return rank;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }
}