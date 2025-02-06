package com.badar.llp.Services;

import com.badar.llp.DTOs.LanguageDTO;
import com.badar.llp.DTOs.TutorDTO;
import com.badar.llp.Models.Language;
import com.badar.llp.Models.Tutor;
import com.badar.llp.Repositories.LanguageRepository;
import com.badar.llp.Utils.HelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {

    @Autowired
    LanguageRepository languageRepository;

    public LanguageDTO getLanguage(Integer id) {
        return LanguageDTO.convertToDTO(languageRepository.getById(id));
    }

    public List<LanguageDTO> getAllLanguages() {
        List<Language> languageList = new ArrayList<>();
        languageList = languageRepository.findAll();
        return LanguageDTO.convertToDTO(languageList);
    }

    public LanguageDTO addLanguage(LanguageDTO dto){
        Language entity = LanguageDTO.convertFromDTO(dto);
        entity.setCreatedDate(new Date());
        entity.setActive(true);
        languageRepository.save(entity);
        LanguageDTO newDTO = LanguageDTO.convertToDTO(entity);
        return newDTO;
    }

    public LanguageDTO updateLanguage(Integer id, LanguageDTO dto) {
        if(HelperUtils.isNotNull(id)){
            Language entity = LanguageDTO.convertFromDTO(dto);
            entity.setUpdatedDate(new Date());
            languageRepository.save(entity);
            LanguageDTO newDTO = LanguageDTO.convertToDTO(entity);
            return newDTO;
        }
        return new LanguageDTO();
    }

    public String deleteLanguageById(Integer id, LanguageDTO dto) {
        if(HelperUtils.isNotNull(id)){
            Language entity = LanguageDTO.convertFromDTO(dto);
            entity.setActive(false);
            entity = languageRepository.save(entity);
            return "Deleted";
        }
        return "Not found";
    }
}