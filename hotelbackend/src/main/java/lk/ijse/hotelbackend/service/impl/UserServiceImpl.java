package lk.ijse.hotelbackend.service.impl;

import lk.ijse.hotelbackend.dto.UserDTO;
import lk.ijse.hotelbackend.entity.User;
import lk.ijse.hotelbackend.repository.UserRepository;
import lk.ijse.hotelbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly =  true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean canAuthenticate(String username, String password,String type) {

        boolean exists = userRepository.existsById(username);

        if (!exists){
            return false;
        }

        User user = userRepository.findById(username).get();

        return user.getPassword().equals(password);

    }

    @Override
    public boolean saveUser(UserDTO userDTO) {
        try{
            userRepository.save(new User(userDTO.getUsername(),userDTO.getPassword(),userDTO.getType()));
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public UserDTO findUserService(String email) {
        return null;
    }
}