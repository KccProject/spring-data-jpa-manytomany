package com.codehub.manytomany.leethub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codehub.manytomany.leethub.model.Answer;
import com.codehub.manytomany.leethub.repository.AnswerRepository;

@Service
public class AnswerService {

    public final AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer saveAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    public Optional<Answer> getAnswerById(Long answer_id) {
        return answerRepository.findById(answer_id);
    }

    public void deleteAnswerById(Long answer_id) {
        answerRepository.deleteById(answer_id);
    }
}