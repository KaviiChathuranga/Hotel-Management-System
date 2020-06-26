package lk.ijse.hotelbackend.controller;

import lk.ijse.hotelbackend.dto.UserDTO;
import lk.ijse.hotelbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/login")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean canAuthenticate(@RequestBody UserDTO user){
        System.out.println("post");
        return userService.canAuthenticate(user.getUsername(), user.getPassword(),user.getType());
    }

    @PostMapping(value = "/{save}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveUser(@RequestBody UserDTO user){
//        System.out.println(user.getUsername()+"  sdsadsa");
       return userService.saveUser(user);
    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO findUser(@PathVariable("id") String id){
        // System.out.println("Id is  :  "+id);
        return userService.findUserService(id);
    }


}
