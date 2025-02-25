package com.badar.llp.Controllers;

import com.badar.llp.DTOs.UserDTO;
import com.badar.llp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("register")
    public UserDTO signUp(@RequestBody UserDTO dto){
        return userService.signup(dto);
    }
//
//    @PostMapping("login")
//    public String login(@RequestBody User user){
//        return userService.login(user);
//    }
}
