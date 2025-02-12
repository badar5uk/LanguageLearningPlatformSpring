package com.badar.llp.Controllers;

import com.badar.llp.DTOs.TutorDTO;
import com.badar.llp.Responses.TutorVideoResponse;
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

    @PutMapping(value = "assignlanguage")
    public TutorDTO assignLanguageToTutor(@RequestParam Integer tutorId, @RequestParam Integer langid) {
        return tutorService.assignLanguageToTutor(tutorId, langid);

    }

    @PutMapping(value = "removelanguage")
    public TutorDTO removeLanguageFromTutor(@RequestParam Integer tutorId, @RequestParam Integer langid) {
        return tutorService.removeLanguageFromTutor(tutorId, langid);

    }

    @PutMapping(value = "assignStudent")
    public TutorDTO addStudentsToTutor(@RequestParam Integer tutorId, @PathVariable Integer studentid){
        return tutorService.addStudentsToTutor(tutorId, studentid);
    }

    @PutMapping(value = "removestudent")
    public TutorDTO removeStudentFromTutor(@RequestParam Integer tutorId, @PathVariable Integer studentid){
        return tutorService.removeStudentFromTutor(tutorId,studentid);
    }

    @GetMapping(value = "getTutorVideos")
        public TutorVideoResponse  getTutorVideos(@RequestParam Integer tutorId){
        return tutorService.getTutorVideo(tutorId);
    }

    @PutMapping(value = "assignVideo")
    public TutorVideoResponse assignTutorVideo(@RequestParam Integer tutorId, @RequestParam Integer videoId){
        return tutorService.assignTutorVideo(tutorId, videoId);
    }

}
