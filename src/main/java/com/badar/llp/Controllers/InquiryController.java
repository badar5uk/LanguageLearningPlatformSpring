package com.badar.llp.Controllers;

import com.badar.llp.DTOs.InquiryDTO;
import com.badar.llp.Services.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "inquiry")
@CrossOrigin(origins = "*")
public class InquiryController {

    @Autowired
    InquiryService inquiryService;

    @GetMapping(value = "getAll")
    @PreAuthorize("hasRole('TUTOR')")
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
