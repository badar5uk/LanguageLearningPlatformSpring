package com.badar.llp.Controllers;

import com.badar.llp.DTOs.InquiryDTO;
import com.badar.llp.DTOs.LanguageDTO;
import com.badar.llp.Services.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "inquiry")
public class inquiryController {

    @Autowired
    InquiryService inquiryService;

    @GetMapping(value = "getAll")
    public List<InquiryDTO> getAllInquiries(){
        return inquiryService.getAllInquiries();
    }

    @GetMapping(value = "{id}")
    public InquiryDTO getInquiryById(@RequestParam Integer id){
        return inquiryService.getInquiryById(id);
    }

    @PostMapping
    public  InquiryDTO addInquiry(@RequestBody InquiryDTO inquiryDTO){
        return inquiryService.addInquiry(inquiryDTO);
    }

    @DeleteMapping(value = "{id}")
    public String deleteInquiryById(@PathVariable Integer id, @RequestBody InquiryDTO inquiryDTO){
        return inquiryService.deleteInquiryById(id,inquiryDTO);
    }
}
