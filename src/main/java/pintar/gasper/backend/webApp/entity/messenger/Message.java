package pintar.gasper.backend.webApp.entity.messenger;

public class Message {

    private Long id;
    private Long idUser;
    private String text;
    private String createdAt;

    public Message() {}

    public Message(Long id, Long idUser, String text, String createdAt) {
        this.id = id;
        this.idUser = idUser;
        this.text = text;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public String getText() {
        return text;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}