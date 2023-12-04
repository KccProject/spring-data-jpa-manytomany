package com.codehub.manytomany.leethub.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "difficulty_id")
    private Difficulty difficulty;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REMOVE }, fetch = FetchType.LAZY)
    @JoinTable(name = "question_topic_mapping", joinColumns = @JoinColumn(name = "question_id"), inverseJoinColumns = @JoinColumn(name = "topic_id"))
    private Set<Topic> topicSet = new HashSet<>();
    private Set<QuestionTopicMapping> questionTopicMappings = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "platform_id")
    private Platform platform;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private Set<Answer> answers = new HashSet<>();
}
