package com.badar.llp.Models;

import jakarta.persistence.Entity;

@Entity
public class Video extends BasicModel{
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
