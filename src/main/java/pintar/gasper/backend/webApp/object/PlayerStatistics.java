package pintar.gasper.backend.webApp.object;

import javax.persistence.Column;

public class PlayerStatistics {

    private int kills;
    private int deaths;
    private int wins;
    private int losses;
    private int highestStreak;
    private int mostKills;

    public PlayerStatistics(int kills, int deaths, int wins, int losses, int highestStreak, int mostKills) {
        this.kills = kills;
        this.deaths = deaths;
        this.wins = wins;
        this.losses = losses;
        this.highestStreak = highestStreak;
        this.mostKills = mostKills;
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
}