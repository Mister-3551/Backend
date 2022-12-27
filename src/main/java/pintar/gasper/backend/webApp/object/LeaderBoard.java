package pintar.gasper.backend.webApp.object;

public class LeaderBoard {

    private int idUser;
    private String username;
    private String picture;
    private int rank;
    private int kills;

    public LeaderBoard(int idUser, String username, String picture, int rank, int kills) {
        this.idUser = idUser;
        this.username = username;
        this.picture = picture;
        this.rank = rank;
        this.kills = kills;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getUsername() {
        return username;
    }

    public String getPicture() {
        return picture;
    }

    public int getRank() {
        return rank;
    }

    public int getKills() {
        return kills;
    }
}