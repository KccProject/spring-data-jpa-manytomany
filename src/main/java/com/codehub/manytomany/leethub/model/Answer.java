package com.codehub.manytomany.leethub.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answer_id;
    private String code_acceptance;
    private String code_language;
    private String answer_url;
    private String answer_code;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

}