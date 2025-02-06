package com.badar.llp.Services;

import com.badar.llp.DTOs.StudentDTO;
import com.badar.llp.Models.Student;
import com.badar.llp.Repositories.StudentRepository;
import com.badar.llp.Utils.HelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentDTO getStudent(Integer id) {
        return StudentDTO.convertToDTO(studentRepository.getById(id));
    }

    public List<StudentDTO> getAllStudent() {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        studentDTOList = StudentDTO.convertToDTO(studentRepository.findAll());
        return studentDTOList;
    }

    public StudentDTO addStudent(StudentDTO dto){
        dto.setCreatedDate(new Date());
        dto.setActive(true);
        StudentDTO newDTO = StudentDTO.convertToDTO(studentRepository.save(StudentDTO.convertFromDTO(dto)));
        return newDTO;
    }

    public StudentDTO updateStudent(Integer id, StudentDTO student) {
        if(HelperUtils.isNotNull(id)){
            student.setUpdatedDate(new Date());
            StudentDTO newDTO = StudentDTO.convertToDTO(studentRepository.save(StudentDTO.convertFromDTO(student)));
            return newDTO;
        }
        return new StudentDTO();
    }

    public String deleteStudentById(Integer id) {
        if(HelperUtils.isNotNull(id)){
            Optional<Student> list = studentRepository.findById(id);
            return "Deleted";
        }
        return "Not found";
    }
}
