package com.codehub.manytomany.leethub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codehub.manytomany.leethub.model.Answer;
import com.codehub.manytomany.leethub.model.Question;
import com.codehub.manytomany.leethub.repository.AnswerRepository;

@Service
public class AnswerService {

    public final AnswerRepository answerRepository;
    public final QuestionService questionService;

    @Autowired
    public AnswerService(AnswerRepository answerRepository, QuestionService questionService) {
        this.answerRepository = answerRepository;
        this.questionService = questionService;
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

    public Answer addQuestionToAnswer(Long answerId, Long questionId) {
        Optional<Answer> optionalAnswer = answerRepository.findById(answerId);
        Optional<Question> optionalQuestion = questionService.getQuestionById(questionId);

        if (optionalAnswer.isPresent() && optionalQuestion.isPresent()) {
            Answer answer = optionalAnswer.get();
            Question question = optionalQuestion.get();

            // Check if the association already exists to avoid duplicates
            if (answer.getQuestion() == null || !answer.getQuestion().equals(question)) {
                answer.setQuestion(question);
                return answerRepository.save(answer);
            } else {
                // Handle case where the association already exists
                return null;
            }
        } else {
            return null;
        }
    }
}