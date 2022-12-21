package pintar.gasper.backend.webApp.object;

public class Message {

    private Long idUser;
    private String text;
    private String createdAt;

    public Message(Long idUser, String text, String createdAt) {
        this.idUser = idUser;
        this.text = text;
        this.createdAt = createdAt;
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
