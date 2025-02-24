package com.badar.llp.Controllers;

import com.badar.llp.Models.User;
import com.badar.llp.Repositories.UserRepository;
import com.badar.llp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public User signUp(@RequestBody User user){
        return userService.signup(user);
    }

    public String login(@RequestBody User user){
        return userService.login(user);
    }
}
