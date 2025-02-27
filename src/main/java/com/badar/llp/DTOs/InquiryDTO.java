package com.badar.llp.DTOs;

import com.badar.llp.Models.Inquiry;
import com.badar.llp.Models.Language;
import com.badar.llp.Utils.HelperUtils;
import jakarta.validation.constraints.Email;

import java.util.ArrayList;
import java.util.List;

public class InquiryDTO {
    private Integer id;
    private String name;
    @Email
    private String email;

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

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public static InquiryDTO convertToDTO(Inquiry inquiry) {
        InquiryDTO dto = new InquiryDTO();
        dto.setId(inquiry.getId());
        dto.setName(inquiry.getName());
        dto.setEmail(inquiry.getEmail());
        return dto;
    }

    public static Inquiry convertFromDTO(InquiryDTO dto) {
        Inquiry inquiry = new Inquiry();
        inquiry.setId(dto.getId());
        inquiry.setName(dto.getName());
        inquiry.setEmail(dto.getEmail());
        return inquiry;
    }

    public static List<InquiryDTO> convertToDTO(List<Inquiry> inquiryList) {
        List<InquiryDTO> inquiryDTOList = new ArrayList<>();
        if (HelperUtils.isNotNull(inquiryList)) {
            for (Inquiry inquiry : inquiryList) {
                inquiryDTOList.add(convertToDTO(inquiry));
            }
            return inquiryDTOList;
        }
        return new ArrayList<>();
    }

    public static List<Inquiry> convertFromDTO(List<InquiryDTO> inquiryDTOList) {
        List<Inquiry> inquiryList = new ArrayList<>();
        if (HelperUtils.isNotNull(inquiryDTOList)) {
            for (InquiryDTO inquiryDTO : inquiryDTOList) {
                inquiryList.add(convertFromDTO(inquiryDTO));
            }
            return inquiryList;
        }
        return new ArrayList<>();
    }
}
