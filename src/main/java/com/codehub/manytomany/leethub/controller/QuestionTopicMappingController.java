// QuestionTopicMappingController.java
package com.codehub.manytomany.leethub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codehub.manytomany.leethub.model.Question;
import com.codehub.manytomany.leethub.model.Topic;
import com.codehub.manytomany.leethub.service.QuestionService;
import com.codehub.manytomany.leethub.service.QuestionTopicMappingService;
import com.codehub.manytomany.leethub.service.TopicService;

@RestController
@RequestMapping("/api/question-topic-mapping")
public class QuestionTopicMappingController {

    private final QuestionTopicMappingService questionTopicMappingService;
    private final QuestionService questionService;
    private final TopicService topicService;

    @Autowired
    public QuestionTopicMappingController(
            QuestionTopicMappingService questionTopicMappingService,
            QuestionService questionService,
            TopicService topicService) {
        this.questionTopicMappingService = questionTopicMappingService;
        this.questionService = questionService;
        this.topicService = topicService;
    }

    @PostMapping("/map/{questionId}/{topicId}")
    public void mapQuestionToTopic(@PathVariable Long questionId, @PathVariable Long topicId) {
        Question question = questionService.getQuestionById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));
        Topic topic = topicService.getTopicById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic not found"));

        questionTopicMappingService.mapQuestionToTopic(question, topic);
    }
}
