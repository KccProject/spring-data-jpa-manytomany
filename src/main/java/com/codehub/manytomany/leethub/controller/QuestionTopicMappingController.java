package com.codehub.manytomany.leethub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codehub.manytomany.leethub.entity.Question;
import com.codehub.manytomany.leethub.service.QuestionService;

@RestController
@RequestMapping("/api/topic/{topic_id}/question/{question_id}")
public class QuestionTopicMappingController {
    @Autowired
    private QuestionService questionService;

    @PutMapping
    public Question assignTopicsToQuestion(
            @PathVariable Long topic_id,
            @PathVariable Long question_id
    ){
        return questionService.assignTopicsToQuestion(topic_id, question_id);
    }

}
