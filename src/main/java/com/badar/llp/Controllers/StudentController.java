package com.badar.llp.Controllers;

import com.badar.llp.DTOs.StudentDTO;
import com.badar.llp.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = "{id}")
    public StudentDTO getStudent(@PathVariable Integer id){
        StudentDTO student = studentService.getStudent(id);
        return student;
    }

    @GetMapping
    public List<StudentDTO> getAllStudent(){
        List<StudentDTO> studentDTOList = studentService.getAllStudent();
        return studentDTOList;
    }

    @PostMapping
    public StudentDTO addStudent(@RequestBody StudentDTO dto){
        StudentDTO newDTO = studentService.addStudent(dto);
        return newDTO;
    }

    @PutMapping(value = "{id}")
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO,@RequestParam Integer id){
        StudentDTO newDTO = studentService.updateStudent(id,studentDTO);
        return newDTO;
    }

    @DeleteMapping(value = "{id}")
    public String deleteStudentById(@RequestParam Integer id){
        return studentService.deleteStudentById(id);
    }
}
