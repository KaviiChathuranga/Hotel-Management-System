package lk.ijse.hotelbackend.entity;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {

    @Id
    private String username;
    private String password;
    private String type;

    public User() {
    }

    public User(String username, String password,String type) {
        this.setUsername(username);
        this.setPassword(password);
        this.setType(type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
