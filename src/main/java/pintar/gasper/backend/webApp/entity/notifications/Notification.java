package pintar.gasper.backend.webApp.entity.notifications;

public class Notification {

    private Long id;
    private String username;
    private String picture;
    private int type;
    private String createdAt;

    public Notification(Long id, String username, String picture, int type, String createdAt) {
        this.id = id;
        this.username = username;
        this.picture = picture;
        this.type = type;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
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