package com.badar.llp.Controllers;

import com.badar.llp.DTOs.TutorDTO;
import com.badar.llp.DTOs.VideoDTO;
import com.badar.llp.Repositories.VideoRepository;
import com.badar.llp.Services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping(value = "{id}")
    public VideoDTO getVideo(@PathVariable Integer id){
        VideoDTO video = videoService.getVideo(id);
        return video;
    }

    @GetMapping
    public List<VideoDTO> getAllVideos(){
        List<VideoDTO> videoDTOList = videoService.getAllVideos();
        return videoDTOList;
    }

    @PostMapping
    public VideoDTO addVideo(@RequestBody VideoDTO dto){
        VideoDTO newDTO = videoService.addVideo(dto);
        return newDTO;
    }

    @PutMapping(value = "{id}")
    public VideoDTO updateVideo(@RequestBody VideoDTO tutorDTO,@RequestParam Integer id){
        VideoDTO newDTO = videoService.updateVideo(id,tutorDTO);
        return newDTO;
    }

    @DeleteMapping(value = "{id}")
    public String deleteVideoById(@RequestParam Integer id){
        return videoService.deleteVideoById(id);
    }
}
