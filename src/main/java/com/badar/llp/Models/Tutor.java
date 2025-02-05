package com.badar.llp.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Tutor extends BasicModel{

    @OneToMany
    private List<Language> language;
    @OneToMany
    private List<Student> student;
}
