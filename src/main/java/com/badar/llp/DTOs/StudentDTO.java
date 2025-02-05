package com.badar.llp.DTOs;

import com.badar.llp.Models.Student;
import com.badar.llp.Utils.HelperUtils;

import java.util.ArrayList;
import java.util.List;

public class StudentDTO {
    private Integer id;
    private String name;

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

    public StudentDTO convertToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        return dto;
    }

    public Student convertFromDTO(StudentDTO dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        return student;
    }

    public List<StudentDTO> convertToDTO(List<Student> studentList) {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        if (HelperUtils.isNotNull(studentList)) {
            for (Student student : studentList) {
                studentDTOList.add(convertToDTO(student));
                return studentDTOList;
            }
        }
        return new ArrayList<>();
    }

    public List<Student> convertFromDTO(List<StudentDTO> studentDTOList) {
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
