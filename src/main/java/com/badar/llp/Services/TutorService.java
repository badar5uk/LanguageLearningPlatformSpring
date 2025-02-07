package com.badar.llp.Services;

import com.badar.llp.DTOs.LanguageDTO;
import com.badar.llp.DTOs.TutorDTO;
import com.badar.llp.Models.Language;
import com.badar.llp.Models.Tutor;
import com.badar.llp.Repositories.LanguageRepository;
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
    @Autowired
    LanguageRepository languageRepository;

    public TutorDTO getTutor(Integer id) {
        return TutorDTO.convertToDTO(tutorRepository.getById(id));
    }

    public List<TutorDTO> getAllTutors() {
        List<Tutor> tutorList = new ArrayList<>();
        tutorList = tutorRepository.findAll();
        return TutorDTO.convertToDTO(tutorList);
    }

    public TutorDTO addTutor(TutorDTO dto){
        Tutor entity = TutorDTO.convertFromDTO(dto);
        entity.setCreatedDate(new Date());
        entity.setActive(true);
        entity = tutorRepository.save(entity);
        TutorDTO newDTO = TutorDTO.convertToDTO(entity);
        return newDTO;
    }

    public TutorDTO updateTutor(Integer id, TutorDTO tutor) {
        if(HelperUtils.isNotNull(id)){
            Tutor entity = TutorDTO.convertFromDTO(tutor);
            entity.setUpdatedDate(new Date());
            entity = tutorRepository.save(entity);
            TutorDTO newDTO = TutorDTO.convertToDTO(entity);
            return newDTO;
        }
        return new TutorDTO();
    }

    public String deleteTutorById(Integer id,TutorDTO tutor) {
        if(HelperUtils.isNotNull(id)){
            Tutor entity = TutorDTO.convertFromDTO(tutor);
            entity.setActive(false);
            entity = tutorRepository.save(entity);
            return "Deleted";
        }
        return "Not found";
    }

    public TutorDTO assignLanguageToTutor(TutorDTO tutorDTO, Integer languageId){
        Language language = languageRepository.findById(languageId).get();
        Tutor tutor = tutorRepository.findById(tutorDTO.getId()).get();
        List<Language> exisitingLanguages = tutor.getLanguageList();
        exisitingLanguages.add(language);
        tutor.setLanguageList(exisitingLanguages);
        tutor = tutorRepository.save(tutor);
        return TutorDTO.convertToDTO(tutor);
   }
}
