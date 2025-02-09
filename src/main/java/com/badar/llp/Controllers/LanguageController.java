package com.badar.llp.Controllers;

import com.badar.llp.DTOs.LanguageDTO;
import com.badar.llp.Services.LanguageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "language")
@CrossOrigin(origins = "*")
public class LanguageController {

    @Autowired
    LanguageService languageService;

    @GetMapping(value = "{id}")
    public LanguageDTO getLanguage(@PathVariable Integer id){
        LanguageDTO lang = languageService.getLanguage(id);
        return lang;
    }

    @GetMapping(value = "getAll")
    public List<LanguageDTO> getAllLanguages(){
        List<LanguageDTO> languageDTOList = languageService.getAllLanguages();
        return languageDTOList;
    }

    @PostMapping
    public LanguageDTO addLanguage(@RequestBody LanguageDTO dto){
        LanguageDTO newDTO = languageService.addLanguage(dto);
        return newDTO;
    }

    @PutMapping(value = "{id}")
    public LanguageDTO updateLanguage(@RequestBody LanguageDTO languageDTO,@PathVariable Integer id){
        LanguageDTO newDTO = languageService.updateLanguage(id,languageDTO);
        return newDTO;
    }

    @DeleteMapping(value = "{id}")
    public String deleteLanguageById(@PathVariable Integer id, @RequestBody LanguageDTO languageDTO){
        return languageService.deleteLanguageById(id,languageDTO);
    }

    @PutMapping(value = "assignvideo/{videoid}")
    public LanguageDTO assignVideoToLanguage(@RequestBody LanguageDTO languageDTO, @PathVariable Integer videoid){
        return languageService.assignVideoToLanguage(languageDTO, videoid);
    }

    @PutMapping(value = "removevideo/{videoid}")
    public LanguageDTO removeVideoFromLanguage(@RequestBody LanguageDTO languageDTO, @PathVariable Integer videoid){
        return languageService.removeVideoFromLanguage(languageDTO, videoid);
    }

}
