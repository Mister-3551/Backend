package pintar.gasper.backend.webApp.object;

public class LevelStatistics {

    private String usedTime;
    private int currentScore;
    private int maxScore;
    private int deaths;

    public LevelStatistics(String usedTime, int currentScore, int maxScore, int deaths) {
        this.usedTime = usedTime;
        this.currentScore = currentScore;
        this.maxScore = maxScore;
        this.deaths = deaths;
    }

    public String getUsedTime() {
        return usedTime;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public int getDeaths() {
        return deaths;
    }
}