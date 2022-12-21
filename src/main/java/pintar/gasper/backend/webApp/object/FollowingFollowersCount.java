package pintar.gasper.backend.webApp.object;

public class FollowingFollowersCount {

    private int following;
    private int followers;

    public FollowingFollowersCount(int following, int followers) {
        this.following = following;
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public int getFollowers() {
        return followers;
    }
}