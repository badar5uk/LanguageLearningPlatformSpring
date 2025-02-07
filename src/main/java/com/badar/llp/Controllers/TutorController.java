package com.badar.llp.Controllers;

import com.badar.llp.DTOs.StudentDTO;
import com.badar.llp.DTOs.TutorDTO;
import com.badar.llp.Services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

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
       return tutorService.assignLanguageToTutor(tutorDTO,langid);

    }
}
