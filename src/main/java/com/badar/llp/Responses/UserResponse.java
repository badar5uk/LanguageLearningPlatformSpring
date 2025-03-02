package com.badar.llp.Responses;

import com.badar.llp.Models.Role;

import java.util.List;

public class UserResponse {
    private String name;
    private String userName;
    private String email;
    private List<VideoResponse> videoList;
    private List<LanguageResponse> languageList;
    private Role role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<VideoResponse> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<VideoResponse> videoList) {
        this.videoList = videoList;
    }

    public List<LanguageResponse> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<LanguageResponse> languageList) {
        this.languageList = languageList;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
