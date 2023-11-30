package com.codehub.manytomany.leethub.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    // private Long user_id;
}