package com.badar.llp.DTOs;

import com.badar.llp.Models.Role;
import com.badar.llp.Models.User;
import com.badar.llp.Utils.HelperUtils;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private String userName;
    private List<LanguageDTO> languageList;
    private List<VideoDTO> videoList;

    public List<LanguageDTO> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<LanguageDTO> languageList) {
        this.languageList = languageList;
    }

    public List<VideoDTO> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<VideoDTO> videoList) {
        this.videoList = videoList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setUserName(user.getUsername());
        dto.setName(user.getName());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        dto.setLanguageList(LanguageDTO.convertToDTO(user.getLanguageList()));
        dto.setVideoList(VideoDTO.convertToDTO(user.getVideoList()));
        return dto;
    }

    public static User convertFromDTO(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUserName());
        user.setName(dto.getName());
        user.setRole(dto.getRole());
        user.setPassword(dto.getPassword());
        user.setLanguageList(LanguageDTO.convertFromDTO(dto.getLanguageList()));
        user.setVideoList(VideoDTO.convertFromDTO(dto.getVideoList()));
        return user;
    }

    private static List<UserDTO> convertToDTO(List<User> userList) {
        List<UserDTO> dtoList = new ArrayList<>();
        if (HelperUtils.isNotNull(userList)) {
            for (User user : userList) {
                dtoList.add(convertToDTO(user));
            }
            return dtoList;
        }
        return new ArrayList<>();
    }

    private static List<User> convertFromDTO(List<UserDTO> dtoList){
        List<User> userList = new ArrayList<>();
        if (HelperUtils.isNotNull(dtoList)){
            for(UserDTO dto : dtoList){
                userList.add(convertFromDTO(dto));
            }
            return userList;
        }
        return new ArrayList<>();
    }

}
