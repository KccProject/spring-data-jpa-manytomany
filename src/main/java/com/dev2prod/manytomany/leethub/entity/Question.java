package com.dev2prod.manytomany.leethub.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long question_id;
    private String question_title;
    private String question_url;
    private Long ques_submissions;
    private Long ques_acceptance_rate;
    private Long ques_likes;
    private Long ques_dislikes;
    private String ques_accepted;

    @JsonIgnore

    @ManyToOne
    @JoinColumn(name = "difficulty_id")
    private Difficulty difficulty;

    @ManyToMany(mappedBy = "questionsSet", cascade = CascadeType.ALL)
    private Set<Topic> topicSet= new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Platform platform;

}
