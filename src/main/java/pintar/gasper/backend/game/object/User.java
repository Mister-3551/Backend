package pintar.gasper.backend.game.object;

public class User {

    private Long id;
    private String name;
    private String username;
    private int rank;

    public User(Long id, String name, String username, int rank) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.rank = rank;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public int getRank() {
        return rank;
    }
}