package pintar.gasper.backend.webApp.entity.users;

public class UsersCount {

    private int following;
    private int followers;

    public UsersCount(int following, int followers) {
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