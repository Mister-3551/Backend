package pintar.gasper.backend.webApp.object;

public class Notifications {

    private Long idNotification;
    private String username;
    private int type;
    private String createdAt;

    public Notifications(Long idNotification, String username, int type, String createdAt) {
        this.idNotification = idNotification;
        this.username = username;
        this.type = type;
        this.createdAt = createdAt;
    }

    public Long getIdNotification() {
        return idNotification;
    }

    public String getUsername() {
        return username;
    }

    public int getType() {
        return type;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}