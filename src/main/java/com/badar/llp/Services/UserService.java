package com.badar.llp.Services;

import com.badar.llp.DTOs.UserDTO;
import com.badar.llp.Models.*;
import com.badar.llp.Repositories.StudentRepository;
import com.badar.llp.Repositories.TutorRepository;
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

import static com.badar.llp.Models.Role.STUDENT;
import static com.badar.llp.Models.Role.TUTOR;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TutorRepository tutorRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    JwtService jwtService;

    public UserDTO signup(UserDTO dto) {
        User newUser = UserDTO.convertFromDTO(dto);
        newUser.setCreatedDate(new Date());
        newUser.setActive(true);
        newUser.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        newUser = userRepository.save(newUser);

        if (newUser.getRole() == TUTOR) {
            Tutor tutor = new Tutor();
            tutor.setName(dto.getName());
            tutor.setCreatedDate(new Date());
            tutor.setActive(true);
            tutor.setUser(newUser);
            tutorRepository.save(tutor);
        } else if (newUser.getRole() == STUDENT) {
            Student student = new Student();
            student.setName(dto.getName());
            student.setCreatedDate(new Date());
            student.setActive(true);
            studentRepository.save(student);
        }
        UserDTO newDTO = UserDTO.convertToDTO(newUser);
        return newDTO;
    }

    public String login(UserDTO dto) throws Exception {
        User user = userRepository.findByUserName(dto.getUserName());
        if (HelperUtils.isNull(user) || !user.getActive()) {
            throw new Exception("User not valid");
        }
        if (!bCryptPasswordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new Exception("User not valid");

        }
        return jwtService.generateToken(dto);
    }

    public List<Role> getRoles() {
        List<Role> roleList = new ArrayList<Role>(EnumSet.allOf(Role.class));
        return roleList;
    }

    public UserResponse getUserInfo(String userName) {
        User user = userRepository.findByUserName(userName);
        UserResponse response = new UserResponse();
        response.setName(user.getName());
        response.setUserName(userName);
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        if (user.getRole() == TUTOR) {
            List<VideoResponse> vResponse = new ArrayList<>();
            Tutor tutor = tutorRepository.findByUserName(userName);
            for (Video video : tutor.getVideoList()) {
                VideoResponse videoResponse = new VideoResponse();
                videoResponse.setLink(video.getLink());
                videoResponse.setTitle(video.getName());
                vResponse.add(videoResponse);

                response.setVideoList(vResponse);
                List<LanguageResponse> lResposne = new ArrayList<>();
                for (Language language : tutor.getLanguageList()) {
                    LanguageResponse languageResponse = new LanguageResponse();
                    languageResponse.setLanguageName(language.getName());
                }
                response.setLanguageList(lResposne);
            }
        } else if (user.getRole() == STUDENT) {
            Student student = studentRepository.findByUserName(userName);
            List<LanguageResponse> lResposne = new ArrayList<>();
            for (Language language : student.getLanguageList()) {
                LanguageResponse languageResponse = new LanguageResponse();
                languageResponse.setLanguageName(language.getName());
            }
            response.setLanguageList(lResposne);
        }
        return response;
    }
}
