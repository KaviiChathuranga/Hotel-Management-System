package lk.ijse.hotelbackend.dto;



public class UserDTO {

    private String username;
    private String password;
    private String type;

    public UserDTO() {
    }

    public UserDTO(String username, String password,String type) {
        this.setUsername(username);
        this.setPassword(password);
        this.setType(type);
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
