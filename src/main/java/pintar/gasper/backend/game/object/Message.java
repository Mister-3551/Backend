package pintar.gasper.backend.game.object;

public class Message {
    private String title;
    private String description;
    private int code;

    public static class Builder {
        private String title;
        private String description;
        private int code;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }

    public Message(Builder builder) {
        title = builder.title;
        description = builder.description;
        code = builder.code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }
}