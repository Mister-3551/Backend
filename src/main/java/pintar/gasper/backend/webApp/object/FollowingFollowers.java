package pintar.gasper.backend.webApp.object;

public class FollowingFollowers {

    private Long id;
    private String username;
    private int rank;
    private String picture;

    public FollowingFollowers(Long id, String username, int rank, String picture) {
        this.id = id;
        this.username = username;
        this.rank = rank;
        this.picture = picture;
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

    public String getPicture() {
        return picture;
    }
}