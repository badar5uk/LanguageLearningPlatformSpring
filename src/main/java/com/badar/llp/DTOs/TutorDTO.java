package com.badar.llp.DTOs;

import com.badar.llp.Models.Tutor;
import com.badar.llp.Utils.HelperUtils;

import java.util.ArrayList;
import java.util.List;

public class TutorDTO {
    private Integer id;
    private String name;

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

    public static TutorDTO convertToDTO(Tutor tutor) {
        TutorDTO dto = new TutorDTO();
        dto.setId(tutor.getId());
        dto.setName(tutor.getName());
        return dto;
    }

    public static Tutor convertFromDTO(TutorDTO dto) {
        Tutor tutor = new Tutor();
        tutor.setId(dto.getId());
        tutor.setName(dto.getName());
        return tutor;
    }

    public static List<TutorDTO> convertToDTO(List<Tutor> tutorList) {
        List<TutorDTO> studentDTOList = new ArrayList<>();
        if (HelperUtils.isNotNull(tutorList)) {
            for (Tutor tutor : tutorList) {
                studentDTOList.add(convertToDTO(tutor));
                return studentDTOList;
            }
        }
        return new ArrayList<>();
    }

    public static List<Tutor> convertFromDTO(List<TutorDTO> tutorDTOList) {
        List<Tutor> tutorList = new ArrayList<>();
        if (HelperUtils.isNotNull(tutorDTOList)) {
            for (TutorDTO tutorDTO : tutorDTOList) {
                tutorList.add(convertFromDTO(tutorDTO));
                return tutorList;
            }
        }
        return new ArrayList<>();
    }
}
