package com.badar.llp.Responses;

import java.util.List;

public class TutorVideoResponse {
    private Integer tutorId;
    private String tutorName;
    private List<VideoResponse> tutorVideo;

    public Integer getTutorId() {
        return tutorId;
    }

    public void setTutorId(Integer tutorId) {
        this.tutorId = tutorId;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public List<VideoResponse> getTutorVideo() {
        return tutorVideo;
    }

    public void setTutorVideo(List<VideoResponse> tutorVideo) {
        this.tutorVideo = tutorVideo;
    }
}
