package com.dev2prod.manytomany.leethub.entity;

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
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long platform_id;
    private String platform_name;

    @OneToMany(mappedBy = "platform",cascade = CascadeType.ALL)
    private Set<Question> questionsSet = new HashSet<>();

}
