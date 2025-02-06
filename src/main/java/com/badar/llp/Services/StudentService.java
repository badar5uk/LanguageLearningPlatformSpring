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
        Student entity = StudentDTO.convertFromDTO(dto);
        entity.setCreatedDate(new Date());
        entity.setActive(true);
        studentRepository.save(entity);
        StudentDTO newDTO = StudentDTO.convertToDTO(entity);
        return newDTO;
    }

    public StudentDTO updateStudent(Integer id, StudentDTO dto) {
        if(HelperUtils.isNotNull(id)){
            Student entity = StudentDTO.convertFromDTO(dto);
            entity.setUpdatedDate(new Date());
            studentRepository.save(entity);
            StudentDTO newDTO = StudentDTO.convertToDTO(entity);
            return newDTO;
        }
        return new StudentDTO();
    }

    public String deleteStudentById(Integer id, StudentDTO dto) {
        if(HelperUtils.isNotNull(id)){
            Student entity = StudentDTO.convertFromDTO(dto);
            entity.setActive(false);
            studentRepository.save(entity);
            return "Deleted";
        }
        return "Not found";
    }
}
