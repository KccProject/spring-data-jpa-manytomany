package com.codehub.manytomany.leethub.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topic_id;
    private String topic_name;

    @JsonIgnore
    @ManyToMany(mappedBy = "topicsSet", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Question> questionsSet = new HashSet<>();

}
