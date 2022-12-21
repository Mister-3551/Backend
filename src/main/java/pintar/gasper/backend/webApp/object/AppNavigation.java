package pintar.gasper.backend.webApp.object;

public class AppNavigation {

    private String username;
    private int rank;

    public AppNavigation() {}

    public AppNavigation(String username, int rank) {
        this.username = username;
        this.rank = rank;
    }

    public String getUsername() {
        return username;
    }

    public int getRank() {
        return rank;
    }
}