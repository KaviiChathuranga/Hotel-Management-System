package lk.ijse.hotelbackend.service;

import lk.ijse.hotelbackend.dto.UserDTO;

public interface UserService {
    boolean canAuthenticate(String username, String password,String x);
    boolean saveUser(UserDTO userDTO);
    UserDTO findUserService(String email);

}
