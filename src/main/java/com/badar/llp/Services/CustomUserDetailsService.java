package com.badar.llp.Services;

import com.badar.llp.CustomUserDetails;
import com.badar.llp.Models.User;
import com.badar.llp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if(Objects.isNull(user)){
            System.out.println("User not Found");
            throw new UsernameNotFoundException("User not Found");
        }
        return new CustomUserDetails(user);
    }
}
