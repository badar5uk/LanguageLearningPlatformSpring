package com.badar.llp.Controllers;

import com.badar.llp.DTOs.TutorDTO;
import com.badar.llp.Services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "tutor")
public class TutorController {

    @Autowired
    TutorService tutorService;

    @GetMapping(value = "{id}")
    public TutorDTO getTutor(@PathVariable Integer id) {
        TutorDTO tutor = tutorService.getTutor(id);
        return tutor;
    }

    @GetMapping(value = "getAll")
    public List<TutorDTO> getAllTutors() {
        List<TutorDTO> tutorDTOList = tutorService.getAllTutors();
        return tutorDTOList;
    }

    @PostMapping
    public TutorDTO addTutor(@RequestBody TutorDTO dto) {
        TutorDTO newDTO = tutorService.addTutor(dto);
        return newDTO;
    }

    @PutMapping(value = "{id}")
    public TutorDTO updateTutor(@RequestBody TutorDTO tutorDTO, @PathVariable Integer id) {
        TutorDTO newDTO = tutorService.updateTutor(id, tutorDTO);
        return newDTO;
    }

    @DeleteMapping(value = "{id}")
    public String deleteTutorById(@PathVariable Integer id, @RequestBody TutorDTO tutorDTO) {
        return tutorService.deleteTutorById(id, tutorDTO);
    }

    @PutMapping(value = "assignlanguage/{langid}")
    public TutorDTO assignLanguageToTutor(@RequestBody TutorDTO tutorDTO, @PathVariable Integer langid) {
        return tutorService.assignLanguageToTutor(tutorDTO, langid);

    }

    @PutMapping(value = "removelanguage/{langid}")
    public TutorDTO removeLanguageFromTutor(@RequestBody TutorDTO tutorDTO, @PathVariable Integer langid) {
        return tutorService.removeLanguageFromTutor(tutorDTO, langid);

    }

    @PutMapping(value = "assignStudent/{studentid}")
    public TutorDTO addStudentsToTutor(@RequestBody TutorDTO tutorDTO, @PathVariable Integer studentid){
        return tutorService.addStudentsToTutor(tutorDTO, studentid);
    }

    @PutMapping(value = "removestudent/{studentid}")
    public TutorDTO removeStudentFromTutor(@RequestBody TutorDTO tutorDTO, @PathVariable Integer studentid){
        return tutorService.removeStudentFromTutor(tutorDTO,studentid);
    }

}
