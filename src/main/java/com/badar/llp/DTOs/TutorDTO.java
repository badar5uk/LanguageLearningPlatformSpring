package com.badar.llp.DTOs;

import com.badar.llp.Models.Tutor;
import com.badar.llp.Utils.HelperUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TutorDTO {
    private Integer id;
    private String name;
    private List<LanguageDTO> languageList;
    private List<StudentDTO> studentList;
    private List<VideoDTO> videoList;
    private UserDTO userDTO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LanguageDTO> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<LanguageDTO> languageList) {
        this.languageList = languageList;
    }

    public List<StudentDTO> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentDTO> studentList) {
        this.studentList = studentList;
    }

    public List<VideoDTO> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<VideoDTO> videoList) {
        this.videoList = videoList;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public static TutorDTO convertToDTO(Tutor tutor) {
        TutorDTO dto = new TutorDTO();
        dto.setId(tutor.getId());
        dto.setName(tutor.getName());
        dto.setLanguageList(LanguageDTO.convertToDTO(tutor.getLanguageList()));
        dto.setStudentList(StudentDTO.convertToDTO(tutor.getStudentList()));
        dto.setVideoList(VideoDTO.convertToDTO(tutor.getVideoList()));
        dto.setUserDTO(UserDTO.convertToDTO(tutor.getUser()));
        return dto;
    }

    public static Tutor convertFromDTO(TutorDTO dto) {
        Tutor tutor = new Tutor();
        tutor.setId(dto.getId());
        tutor.setName(dto.getName());
        tutor.setLanguageList(LanguageDTO.convertFromDTO(dto.getLanguageList()));
        tutor.setStudentList(StudentDTO.convertFromDTO(dto.getStudentList()));
        tutor.setVideoList(VideoDTO.convertFromDTO(dto.getVideoList()));
        tutor.setUser(UserDTO.convertFromDTO(dto.getUserDTO()));
        return tutor;
    }

    public static List<TutorDTO> convertToDTO(List<Tutor> tutorList) {
        List<TutorDTO> tutorDTOList = new ArrayList<>();
        if (HelperUtils.isNotNull(tutorList)) {
            for (Tutor tutor : tutorList) {
                tutorDTOList.add(convertToDTO(tutor));
            }
            return tutorDTOList;
        }
        return new ArrayList<>();
    }

    public static List<Tutor> convertFromDTO(List<TutorDTO> tutorDTOList) {
        List<Tutor> tutorList = new ArrayList<>();
        if (HelperUtils.isNotNull(tutorDTOList)) {
            for (TutorDTO tutorDTO : tutorDTOList) {
                tutorList.add(convertFromDTO(tutorDTO));
            }
            return tutorList;
        }
        return new ArrayList<>();
    }
}
