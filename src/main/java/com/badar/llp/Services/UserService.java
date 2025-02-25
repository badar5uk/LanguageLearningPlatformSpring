package com.badar.llp.Services;

import com.badar.llp.DTOs.UserDTO;
import com.badar.llp.Models.User;
import com.badar.llp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDTO signup(UserDTO dto){
        User newUser = UserDTO.convertFromDTO(dto);
        newUser.setCreatedDate(new Date());
        newUser.setActive(true);
        newUser.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        userRepository.save(newUser);
        UserDTO newDTO = UserDTO.convertToDTO(newUser);
        return newDTO;
    }

    public String login(UserDTO dto){
        if(userRepository.findByUserName(dto.getUserName()) != null){
            return "Success";
        }
        return "User not Found";
    }
}
