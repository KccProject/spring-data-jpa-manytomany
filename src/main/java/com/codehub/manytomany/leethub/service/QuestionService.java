package com.codehub.manytomany.leethub.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codehub.manytomany.leethub.model.Question;
import com.codehub.manytomany.leethub.model.Topic;
import com.codehub.manytomany.leethub.repository.QuestionRepository;
import com.codehub.manytomany.leethub.repository.TopicRepository;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final TopicService topicService;
    private final TopicRepository topicRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, TopicService topicService,
            TopicRepository topicRepository) {
        this.questionRepository = questionRepository;
        this.topicService = topicService;
        this.topicRepository = topicRepository;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    // public ResponseEntity<String> addTopicToQuestion(Long questionId, Long
    // topicId) {
    // Optional<Question> optionalQuestion =
    // questionRepository.findById(questionId);
    // Optional<Topic> optionalTopic = topicService.getTopicById(topicId);

    // if (optionalQuestion.isPresent() && optionalTopic.isPresent()) {
    // Question question = optionalQuestion.get();
    // Topic topic = optionalTopic.get();

    // // Check if the association already exists to avoid duplicates
    // if (!question.getTopicSet().contains(topic)) {
    // question.getTopicSet().add(topic);
    // saveQuestion(question);

    // // Bidirectional association: Add the question to the topic
    // if (!topic.getQuestionsSet().contains(question)) {
    // topic.getQuestionsSet().add(question);
    // topicService.saveTopic(topic);
    // }

    // return ResponseEntity.ok("Topic associated with the question, and question
    // associated with the topic.");
    // } else {
    // return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    // .body("Topic is already associated with the question.");
    // }
    // } else {
    // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question or Topic
    // not found.");
    // }
    // }

    public Question addTopicToQuestion(Long questionId, Long topicId) {
        Set<Topic> topicSet = null;
        Question question = questionRepository.findById(questionId).get();
        Topic topic = topicRepository.findById(topicId).get();
        topicSet = question.getTopicsSet();
        topicSet.add(topic);
        question.setTopicsSet(topicSet);
        return questionRepository.save(question);
    }

}