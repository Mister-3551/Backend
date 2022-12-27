package pintar.gasper.backend.webApp.object;

public class Notifications {

    private Long idNotification;
    private String username;
    private String picture;
    private int type;
    private String createdAt;

    public Notifications(Long idNotification, String username, String picture, int type, String createdAt) {
        this.idNotification = idNotification;
        this.username = username;
        this.picture = picture;
        this.type = type;
        this.createdAt = createdAt;
    }

    public Long getIdNotification() {
        return idNotification;
    }

    public String getUsername() {
        return username;
    }

    public String getPicture() {
        return picture;
    }

    public int getType() {
        return type;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}