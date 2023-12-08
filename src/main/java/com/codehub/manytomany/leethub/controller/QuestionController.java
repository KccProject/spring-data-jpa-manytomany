package com.codehub.manytomany.leethub.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codehub.manytomany.leethub.model.Question;
import com.codehub.manytomany.leethub.service.DifficultyService;
import com.codehub.manytomany.leethub.service.PlatformService;
import com.codehub.manytomany.leethub.service.QuestionService;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService, PlatformService platformService,
            DifficultyService difficultyService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public Optional<Question> getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }

    @PostMapping("/save")
    public Question saveQuestion(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }

    @PutMapping("/{questionId}/add-topic/{topicId}")
    public Question addTopicToQuestion(
            @PathVariable Long questionId,
            @PathVariable Long topicId) {
        return questionService.addTopicToQuestion(questionId, topicId);
    }

    @PutMapping("/{questionId}/add-platform/{platformId}")
    public ResponseEntity<Question> addPlatformToQuestion(
            @PathVariable Long questionId,
            @PathVariable Long platformId) {
        Question updatedQuestion = questionService.addPlatformToQuestion(questionId, platformId);
        if (updatedQuestion != null) {
            return ResponseEntity.ok(updatedQuestion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{questionId}/add-difficulty/{difficultyId}")
    public ResponseEntity<Question> addDifficultyToQuestion(
            @PathVariable Long questionId,
            @PathVariable Long difficultyId) {
        Question updatedQuestion = questionService.addDifficultyToQuestion(questionId, difficultyId);
        if (updatedQuestion != null) {
            return ResponseEntity.ok(updatedQuestion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{questionId}/add-user/{userId}")
    public ResponseEntity<Question> addUserToQuestion(
            @PathVariable Long questionId,
            @PathVariable Long userId) {
        Question updatedQuestion = questionService.addUserToQuestion(questionId, userId);
        if (updatedQuestion != null) {
            return ResponseEntity.ok(updatedQuestion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // @PutMapping("/{questionId}/add-answer/{answerId}")
    // public ResponseEntity<Question> addAnswerToQuestion(
    // @PathVariable Long questionId,
    // @PathVariable Long answerId) {
    // Question updatedQuestion = questionService.addAnswerToQuestion(questionId,
    // answerId);
    // if (updatedQuestion != null) {
    // return ResponseEntity.ok(updatedQuestion);
    // } else {
    // return ResponseEntity.notFound().build();
    // }
    // }
}
