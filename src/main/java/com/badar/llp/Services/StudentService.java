package com.badar.llp.Services;

import com.badar.llp.DTOs.LanguageDTO;
import com.badar.llp.DTOs.StudentDTO;
import com.badar.llp.Models.Language;
import com.badar.llp.Models.Student;
import com.badar.llp.Models.Video;
import com.badar.llp.Repositories.LanguageRepository;
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
    @Autowired
    LanguageRepository languageRepository;

    public StudentDTO getStudent(Integer id) {
        return StudentDTO.convertToDTO(studentRepository.getById(id));
    }

    public List<StudentDTO> getAllStudent() {
        List<Student> studentList = new ArrayList<>();
        studentList = studentRepository.findAll();
        return StudentDTO.convertToDTO(studentList);
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
    public StudentDTO assignLanguageToStudent(Integer studentId, Integer langid){
        Language language = languageRepository.findById(langid).get();
        Student student = studentRepository.getById(studentId);
        List<Language> exitingLanguageList = student.getLanguageList();
        exitingLanguageList.add(language);
        student.setLanguageList(exitingLanguageList);
        student = studentRepository.save(student);
        return StudentDTO.convertToDTO(student);
    }
    public StudentDTO removeLanguageToStudent(Integer studentId, Integer langid){
        Language language = languageRepository.findById(langid).get();
        Student student = studentRepository.getById(studentId);
        List<Language> exitingLanguageList = student.getLanguageList();
        exitingLanguageList.remove(language);
        student.setLanguageList(exitingLanguageList);
        student = studentRepository.save(student);
        return StudentDTO.convertToDTO(student);
    }

}
