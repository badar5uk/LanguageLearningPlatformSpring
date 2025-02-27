package com.badar.llp.Models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;

@Entity
public class Inquiry extends BasicModel{

    @Email
    private String email;
    private String inquiry;

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public String getInquiry() {
        return inquiry;
    }

    public void setInquiry(String inquiry) {
        this.inquiry = inquiry;
    }
}
