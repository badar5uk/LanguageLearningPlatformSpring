package com.badar.llp.Services;

import com.badar.llp.DTOs.InquiryDTO;
import com.badar.llp.DTOs.VideoDTO;
import com.badar.llp.Models.Inquiry;
import com.badar.llp.Models.Video;
import com.badar.llp.Repositories.InquiryRepository;
import com.badar.llp.Utils.HelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InquiryService {

    @Autowired
    InquiryRepository inquiryRepository;

    public List<InquiryDTO> getAllInquiries(){
        List<Inquiry> inquiryList = inquiryRepository.findAll();
        return InquiryDTO.convertToDTO(inquiryList);
    }

    public InquiryDTO getInquiryById(Integer id){
        return InquiryDTO.convertToDTO(inquiryRepository.getById(id));
    }

    public InquiryDTO addInquiry(InquiryDTO dto){
        Inquiry entity = InquiryDTO.convertFromDTO(dto);
        entity.setActive(true);
        entity.setCreatedDate(new Date());
        inquiryRepository.save(entity);
        InquiryDTO inquiryDTO = InquiryDTO.convertToDTO(entity);
        return inquiryDTO;
    }

    public String deleteInquiryById(Integer id, InquiryDTO inquiryDTO){
        if(HelperUtils.isNotNull(id)){
            Inquiry entity = InquiryDTO.convertFromDTO(inquiryDTO);
            entity.setActive(false);
            inquiryRepository.save(entity);
            return "Deleted";
        }
        return "Not found";
    }
}
