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
        return studentService.getStudent(id);
    }

    @GetMapping(value = "getAll")
    public List<StudentDTO> getAllStudent(){
        return studentService.getAllStudent();
    }

    @PostMapping
    public StudentDTO addStudent(@RequestBody StudentDTO dto){
        return studentService.addStudent(dto);
    }

    @PutMapping(value = "{id}")
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO,@PathVariable Integer id){
         return studentService.updateStudent(id,studentDTO);
    }

    @DeleteMapping(value = "{id}")
    public String deleteStudentById(@PathVariable Integer id, @RequestBody StudentDTO studentDTO){
        return studentService.deleteStudentById(id, studentDTO);
    }

    @PutMapping(value = "assignlanguage")
    public StudentDTO assignLanguageToStudent(@RequestParam Integer studentId, @RequestParam Integer langid){
        return studentService.assignLanguageToStudent(studentId, langid);
    }

    @PutMapping(value = "removelanguage")
    public StudentDTO removeLanguageToStudent(@RequestParam Integer studentId, @RequestParam Integer langid){
        return studentService.removeLanguageToStudent(studentId, langid);
    }

}
