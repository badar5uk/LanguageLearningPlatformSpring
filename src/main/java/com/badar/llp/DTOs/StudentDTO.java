package com.badar.llp.DTOs;

import com.badar.llp.Models.Student;
import com.badar.llp.Models.User;
import com.badar.llp.Utils.HelperUtils;

import java.util.ArrayList;
import java.util.List;

public class StudentDTO {
    private Integer id;
    private String name;
    private List<LanguageDTO> languageList;
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public static StudentDTO convertToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setLanguageList(LanguageDTO.convertToDTO(student.getLanguageList()));
        dto.setUserDTO(UserDTO.convertToDTO(student.getUser()));
        return dto;
    }

    public static Student convertFromDTO(StudentDTO dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setLanguageList(LanguageDTO.convertFromDTO(dto.getLanguageList()));
        student.setUser(UserDTO.convertFromDTO(dto.getUserDTO()));
        return student;
    }

    public static List<StudentDTO> convertToDTO(List<Student> studentList) {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        if (HelperUtils.isNotNull(studentList)) {
            for (Student student : studentList) {
                studentDTOList.add(convertToDTO(student));
            }
            return studentDTOList;
        }
        return new ArrayList<>();
    }

    public static List<Student> convertFromDTO(List<StudentDTO> studentDTOList) {
        List<Student> studentList = new ArrayList<>();
        if (HelperUtils.isNotNull(studentDTOList)) {
            for (StudentDTO studentDTO : studentDTOList) {
                studentList.add(convertFromDTO(studentDTO));
            }
            return studentList;
        }
        return new ArrayList<>();
    }
}
