package com.badar.llp.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.annotation.processing.Generated;

@Entity
public class Tutor {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
}
