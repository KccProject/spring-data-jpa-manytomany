package com.codehub.manytomany.leethub.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Difficulty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long difficulty_id;
    private String difficulty_name;

    @OneToMany(mappedBy = "difficulty", cascade = CascadeType.ALL)
    private Set<Question> questionsSet = new HashSet<>();

}
