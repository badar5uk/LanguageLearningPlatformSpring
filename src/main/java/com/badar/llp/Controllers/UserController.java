package com.badar.llp.Controllers;

import com.badar.llp.DTOs.UserDTO;
import com.badar.llp.Models.Role;
import com.badar.llp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("register")
    public UserDTO signUp(@RequestBody UserDTO dto) {
        return userService.signup(dto);
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody UserDTO dto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("token", userService.login(dto)));
    }

    @GetMapping("roles")
    public List<Role> getAllRoles(){
        return userService.getRoles();
    }
}
