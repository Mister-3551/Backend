package pintar.gasper.backend.webApp.object;

public class PlayerStatistics {

    private String username;
    private int rank;
    private int currentXp;
    private int nextLevelXp;
    private String picture;
    private int kills;
    private int deaths;
    private int wins;
    private int losses;
    private int highestStreak;
    private int mostKills;
    private float ratio;

    public PlayerStatistics() {}

    public PlayerStatistics(String username, int rank, int currentXp, int nextLevelXp, String picture, int kills, int deaths, int wins, int losses, int highestStreak, int mostKills, float ratio) {
        this.username = username;
        this.rank = rank;
        this.currentXp = currentXp;
        this.nextLevelXp = nextLevelXp;
        this.picture = picture;
        this.kills = kills;
        this.deaths = deaths;
        this.wins = wins;
        this.losses = losses;
        this.highestStreak = highestStreak;
        this.mostKills = mostKills;
        this.ratio = ratio;
    }

    public String getUsername() {
        return username;
    }

    public int getRank() {
        return rank;
    }

    public int getCurrentXp() {
        return currentXp;
    }

    public int getNextLevelXp() {
        return nextLevelXp;
    }

    public String getPicture() {
        return picture;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getHighestStreak() {
        return highestStreak;
    }

    public int getMostKills() {
        return mostKills;
    }

    public float getRatio() {
        return ratio;
    }
}