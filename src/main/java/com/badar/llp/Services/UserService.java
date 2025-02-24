package com.badar.llp.Services;

import com.badar.llp.Models.User;
import com.badar.llp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User signup(User user){
       return userRepository.save(user);
    }

    public String login(User user){
        if(userRepository.findByUserName(user.getUsername()).equals(true)){
            return "Success";
        }
        return "User not Found";
    }
}
