package pintar.gasper.backend.webApp.object;

public class LevelStatistics {

    private String name;
    private String finishTime;
    private int currentScore;
    private int maxScore;
    private int deaths;

    public LevelStatistics(String name, String finishTime, int currentScore, int maxScore, int deaths) {
        this.name = name;
        this.finishTime = finishTime;
        this.currentScore = currentScore;
        this.maxScore = maxScore;
        this.deaths = deaths;
    }

    public String getName() {
        return name;
    }

    public String getFinishTime() {
        return finishTime;
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