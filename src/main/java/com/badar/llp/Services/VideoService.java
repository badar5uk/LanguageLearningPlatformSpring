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
        List<VideoDTO> videoDTOList = new ArrayList<>();
        videoDTOList = VideoDTO.convertToDTO(videoRepository.findAll());
        return videoDTOList;
    }

    public VideoDTO addVideo(VideoDTO dto){
        dto.setCreatedDate(new Date());
        dto.setActive(true);
        VideoDTO newDTO = VideoDTO.convertToDTO(videoRepository.save(VideoDTO.convertFromDTO(dto)));
        return newDTO;
    }


    public VideoDTO updateVideo(Integer id, VideoDTO video) {
        if(HelperUtils.isNotNull(id)){
            video.setUpdatedDate(new Date());
            VideoDTO newDTO = VideoDTO.convertToDTO(videoRepository.save(VideoDTO.convertFromDTO(video)));
            return newDTO;
        }
        return new VideoDTO();
    }

    public String deleteVideoById(Integer id) {
        if(HelperUtils.isNotNull(id)){
            Optional<Video> list = videoRepository.findById(id);
            return "Deleted";
        }
        return "Not found";
    }
}
