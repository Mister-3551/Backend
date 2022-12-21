package pintar.gasper.backend.webApp.object;

public class FollowingFollowers {

    private Long id;
    private String username;
    private int rank;

    public FollowingFollowers(Long id, String username, int rank) {
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
