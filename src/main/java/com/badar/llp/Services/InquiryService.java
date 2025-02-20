package com.badar.llp.Services;

import com.badar.llp.DTOs.InquiryDTO;
import com.badar.llp.Models.Inquiry;
import com.badar.llp.Repositories.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryService {

    @Autowired
    InquiryRepository inquiryRepository;

    public List<InquiryDTO> getAllInquiries(){
        List<Inquiry> inquiryList = inquiryRepository.findAll();
        return InquiryDTO.convertToDTO(inquiryList);
    }
}
