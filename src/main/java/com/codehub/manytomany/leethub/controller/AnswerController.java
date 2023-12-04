package com.codehub.manytomany.leethub.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codehub.manytomany.leethub.model.Answer;
import com.codehub.manytomany.leethub.service.AnswerService;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {
    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/save")
    public Answer saveAnswer(@RequestBody Answer answer) {
        return answerService.saveAnswer(answer);
    }

    @GetMapping
    public List<Answer> getAllAnswers() {
        return answerService.getAllAnswers();
    }

    @GetMapping("/{answer_id}")
    public Answer getAnswerById(@PathVariable Long answer_id) {
        Optional<Answer> ans = answerService.getAnswerById(answer_id);
        if (ans.isPresent()) {
            return ans.get();

        } else {
            return new Answer();
        }
    }

    @DeleteMapping(value = "/{answer_id}")
    public void deleteAnswerById(@PathVariable Long answer_id) {
        answerService.deleteAnswerById(answer_id);
    }
}