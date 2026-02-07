package model;

public class UserModel {
    String username;
    String password;
    Role role;
    
    public UserModel(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public Role getRole() {
        return role;
    }

    
}
