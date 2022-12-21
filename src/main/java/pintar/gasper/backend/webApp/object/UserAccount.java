package pintar.gasper.backend.webApp.object;

public class UserAccount {

    private String name;
    private String email;

    public UserAccount() {}

    public UserAccount(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}