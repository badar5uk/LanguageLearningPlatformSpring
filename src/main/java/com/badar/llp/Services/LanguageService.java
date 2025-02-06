package com.badar.llp.Services;

import com.badar.llp.DTOs.LanguageDTO;
import com.badar.llp.Models.Language;
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
        List<LanguageDTO> languageDTOList = new ArrayList<>();
        languageDTOList = LanguageDTO.convertToDTO(languageRepository.findAll());
        return languageDTOList;
    }

    public LanguageDTO addLanguage(LanguageDTO dto){
        dto.setCreatedDate(new Date());
        dto.setActive(true);
        LanguageDTO newDTO = LanguageDTO.convertToDTO(languageRepository.save(LanguageDTO.convertFromDTO(dto)));
        return newDTO;
    }

    public LanguageDTO updateLanguage(Integer id, LanguageDTO language) {
        if(HelperUtils.isNotNull(id)){
            language.setUpdatedDate(new Date());
           LanguageDTO newDTO = LanguageDTO.convertToDTO(languageRepository.save(LanguageDTO.convertFromDTO(language)));
           return newDTO;
        }
        return new LanguageDTO();
    }

    public String deleteLanguage(Integer id) {
        if(HelperUtils.isNotNull(id)){
            //languageRepository.deleteById(id);
            Optional<Language> list = languageRepository.findById(id);
            return "Deleted";
        }
        return "Not found";
    }
}