package pintar.gasper.backend.webApp.object;

public class SearchUser {

    private Long id;
    private String username;
    private int rank;

    public SearchUser(Long id, String username, int rank) {
        this.id = id;
        this.username = username;
        this.rank = rank;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getRank() {
        return rank;
    }
}