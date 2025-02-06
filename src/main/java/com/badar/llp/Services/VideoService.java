package com.badar.llp.Services;

import com.badar.llp.DTOs.StudentDTO;
import com.badar.llp.DTOs.VideoDTO;
import com.badar.llp.Models.Student;
import com.badar.llp.Models.Video;
import com.badar.llp.Repositories.VideoRepository;
import com.badar.llp.Utils.HelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    VideoRepository videoRepository;

    public VideoDTO getVideo(Integer id) {
        return VideoDTO.convertToDTO(videoRepository.getById(id));
    }

    public List<VideoDTO> getAllVideos() {
        List<Video> videoList = new ArrayList<>();
        videoList = videoRepository.findAll();
        return VideoDTO.convertToDTO(videoList);
    }

    public VideoDTO addVideo(VideoDTO dto){
        Video entity = VideoDTO.convertFromDTO(dto);
        entity.setCreatedDate(new Date());
        entity.setActive(true);
        videoRepository.save(entity);
        VideoDTO newDTO = VideoDTO.convertToDTO(entity);
        return newDTO;
    }


    public VideoDTO updateVideo(Integer id, VideoDTO dto) {
        if(HelperUtils.isNotNull(id)){
            Video entity = VideoDTO.convertFromDTO(dto);
            entity.setUpdatedDate(new Date());
            videoRepository.save(entity);
            VideoDTO newDTO = VideoDTO.convertToDTO(entity);
            return newDTO;
        }
        return new VideoDTO();
    }

    public String deleteVideoById(Integer id, VideoDTO dto) {
        if(HelperUtils.isNotNull(id)){
            Video entity = VideoDTO.convertFromDTO(dto);
            entity.setActive(false);
            videoRepository.save(entity);
            return "Deleted";
        }
        return "Not found";
    }
}
