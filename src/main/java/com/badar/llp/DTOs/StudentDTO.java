package com.badar.llp.DTOs;

import com.badar.llp.Models.Language;
import com.badar.llp.Models.Student;
import com.badar.llp.Utils.HelperUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDTO {
    private Integer id;
    private String name;
    private Date createdDate;
    private Date updatedDate;
    private Boolean isActive;
    private List<LanguageDTO> languageList;

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public static StudentDTO convertToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setLanguageList(LanguageDTO.convertToDTO(student.getLanguageList()));
        return dto;
    }

    public static Student convertFromDTO(StudentDTO dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setLanguageList(LanguageDTO.convertFromDTO(dto.getLanguageList()));
        return student;
    }

    public static List<StudentDTO> convertToDTO(List<Student> studentList) {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        if (HelperUtils.isNotNull(studentList)) {
            for (Student student : studentList) {
                studentDTOList.add(convertToDTO(student));
                return studentDTOList;
            }
        }
        return new ArrayList<>();
    }

    public static List<Student> convertFromDTO(List<StudentDTO> studentDTOList) {
        List<Student> studentList = new ArrayList<>();
        if (HelperUtils.isNotNull(studentDTOList)) {
            for (StudentDTO studentDTO : studentDTOList) {
                studentList.add(convertFromDTO(studentDTO));
                return studentList;
            }
        }
        return new ArrayList<>();
    }
}
