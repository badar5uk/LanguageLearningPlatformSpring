package com.badar.llp.DTOs;

import com.badar.llp.Models.Tutor;
import com.badar.llp.Models.Video;
import com.badar.llp.Utils.HelperUtils;

import java.util.ArrayList;
import java.util.List;

public class VideoDTO {
    private Integer id;
    private String name;
    private String link;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public static VideoDTO convertToDTO(Video video) {
        VideoDTO dto = new VideoDTO();
        dto.setId(video.getId());
        dto.setName(video.getName());
        dto.setLink(video.getLink());
        return dto;
    }

    public static Video convertFromDTO(VideoDTO dto) {
        Video video = new Video();
        video.setId(dto.getId());
        video.setName(dto.getName());
        video.setLink(dto.getLink());
        return video;
    }

    public static List<VideoDTO> convertToDTO(List<Video> videoList) {
        List<VideoDTO> videoDTOList = new ArrayList<>();
        if (HelperUtils.isNotNull(videoList)) {
            for (Video video : videoList) {
                videoDTOList.add(convertToDTO(video));
                return videoDTOList;
            }
        }
        return new ArrayList<>();
    }

    public static List<Video> convertFromDTO(List<VideoDTO> videoDTOList) {
        List<Video> videoList = new ArrayList<>();
        if (HelperUtils.isNotNull(videoDTOList)) {
            for (VideoDTO videoDTO : videoDTOList) {
                videoList.add(convertFromDTO(videoDTO));
                return videoList;
            }
        }
        return new ArrayList<>();
    }
}
