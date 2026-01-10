
public abstract class User {
    private String username;
    private String password;
    private String name;

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public boolean login(String u, String p) {
        return username.equals(u) && password.equals(p);
    }

    public String getName() {
        return name;
    }

    public String getUsername(){
        return username;
    }
}

