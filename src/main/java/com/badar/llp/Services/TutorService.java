package com.badar.llp.Services;

import com.badar.llp.DTOs.LanguageDTO;
import com.badar.llp.DTOs.TutorDTO;
import com.badar.llp.Models.Language;
import com.badar.llp.Models.Tutor;
import com.badar.llp.Repositories.TutorRepository;
import com.badar.llp.Utils.HelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TutorService {

    @Autowired
    TutorRepository tutorRepository;

    public TutorDTO getTutor(Integer id) {
        return TutorDTO.convertToDTO(tutorRepository.getById(id));
    }

    public List<TutorDTO> getAllTutors() {
        List<TutorDTO> tutorDTOList = new ArrayList<>();
        tutorDTOList = TutorDTO.convertToDTO(tutorRepository.findAll());
        return tutorDTOList;
    }

    public TutorDTO addTutor(TutorDTO dto){
        dto.setCreatedDate(new Date());
        dto.setActive(true);
        TutorDTO newDTO = TutorDTO.convertToDTO(tutorRepository.save(TutorDTO.convertFromDTO(dto)));
        return newDTO;
    }

    public TutorDTO updateTutor(Integer id, TutorDTO tutor) {
        if(HelperUtils.isNotNull(id)){
            tutor.setUpdatedDate(new Date());
            TutorDTO newDTO = TutorDTO.convertToDTO(tutorRepository.save(TutorDTO.convertFromDTO(tutor)));
            return newDTO;
        }
        return new TutorDTO();
    }

    public String deleteTutorById(Integer id) {
        if(HelperUtils.isNotNull(id)){
            Optional<Tutor> list = tutorRepository.findById(id);
            return "Deleted";
        }
        return "Not found";
    }
}
