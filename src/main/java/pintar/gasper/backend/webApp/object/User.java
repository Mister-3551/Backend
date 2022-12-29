package pintar.gasper.backend.webApp.object;

public class User {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String role;

    public User() {}

    public User(Long id, String name, String username, String email, String role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}