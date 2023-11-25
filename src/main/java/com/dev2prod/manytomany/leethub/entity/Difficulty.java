package com.dev2prod.manytomany.leethub.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Difficulty {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long difficulty_id;
    private String difficulty_name;

}
