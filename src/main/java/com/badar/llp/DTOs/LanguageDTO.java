package com.badar.llp.DTOs;

import com.badar.llp.Models.Language;
import com.badar.llp.Utils.HelperUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LanguageDTO {
    private Integer id;
    private String name;
    private List<VideoDTO> videoDTOList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VideoDTO> getVideoDTOList() {
        return videoDTOList;
    }

    public void setVideoDTOList(List<VideoDTO> videoDTOList) {
        this.videoDTOList = videoDTOList;
    }

    public static LanguageDTO convertToDTO(Language language) {
        LanguageDTO dto = new LanguageDTO();
        dto.setId(language.getId());
        dto.setName(language.getName());
        dto.setVideoDTOList(VideoDTO.convertToDTO(language.getVideoList()));
        return dto;
    }

    public static Language convertFromDTO(LanguageDTO dto) {
        Language language = new Language();
        language.setId(dto.getId());
        language.setName(dto.getName());
        return language;
    }

    public static List<LanguageDTO> convertToDTO(List<Language> languageList) {
        List<LanguageDTO> languageDTOList = new ArrayList<>();
        if (HelperUtils.isNotNull(languageList)) {
            for (Language lang : languageList) {
                languageDTOList.add(convertToDTO(lang));
            }
            return languageDTOList;
        }
        return new ArrayList<>();
    }

    public static List<Language> convertFromDTO(List<LanguageDTO> languageDTOList) {
        List<Language> languageList = new ArrayList<>();
        if (HelperUtils.isNotNull(languageDTOList)) {
            for (LanguageDTO langDTO : languageDTOList) {
                languageList.add(convertFromDTO(langDTO));
            }
            return languageList;
        }
        return new ArrayList<>();
    }
}
