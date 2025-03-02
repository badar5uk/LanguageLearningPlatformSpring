package com.badar.llp.Services;

import com.badar.llp.DTOs.UserDTO;
import com.badar.llp.Models.Language;
import com.badar.llp.Models.Role;
import com.badar.llp.Models.User;
import com.badar.llp.Models.Video;
import com.badar.llp.Repositories.UserRepository;
import com.badar.llp.Responses.LanguageResponse;
import com.badar.llp.Responses.UserResponse;
import com.badar.llp.Responses.VideoResponse;
import com.badar.llp.Utils.HelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    JwtService jwtService;

    public UserDTO signup(UserDTO dto){
        User newUser = UserDTO.convertFromDTO(dto);
        newUser.setCreatedDate(new Date());
        newUser.setActive(true);
        newUser.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        userRepository.save(newUser);
        UserDTO newDTO = UserDTO.convertToDTO(newUser);
        return newDTO;
    }

    public String login(UserDTO dto) throws Exception {
        User user = userRepository.findByUserName(dto.getUserName());
        if(HelperUtils.isNull(user) || !user.getActive()){
            throw new Exception("User not valid");
        }
        if(!bCryptPasswordEncoder.matches(dto.getPassword(), user.getPassword())){
            throw new Exception("User not valid");

        }
        return jwtService.generateToken(dto);
    }
    public List<Role> getRoles(){
        List<Role> roleList = new ArrayList<Role>(EnumSet.allOf(Role.class));
        return roleList;
    }

    public UserResponse getUserInfo(String userName){
        User user = userRepository.findByUserName(userName);
        UserResponse response = new UserResponse();
        response.setName(user.getName());
        response.setUserName(userName);
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        List<VideoResponse> vResponse = new ArrayList<>();
        for(Video video: user.getVideoList()){
            VideoResponse videoResponse = new VideoResponse();
            videoResponse.setLink(video.getLink());
            videoResponse.setTitle(video.getName());
            vResponse.add(videoResponse);
        }
        response.setVideoList(vResponse);
        List<LanguageResponse> lResposne = new ArrayList<>();
        for(Language language: user.getLanguageList()){
            LanguageResponse languageResponse = new LanguageResponse();
            languageResponse.setLanguageName(language.getName());
        }
        response.setLanguageList(lResposne);
        return response;
    }
}
