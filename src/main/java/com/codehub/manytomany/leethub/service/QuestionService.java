package com.codehub.manytomany.leethub.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codehub.manytomany.leethub.entity.Question;
import com.codehub.manytomany.leethub.entity.Topic;
import com.codehub.manytomany.leethub.repository.QuestionRepository;
import com.codehub.manytomany.leethub.repository.TopicRepository;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final TopicRepository topicRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, TopicRepository topicRepository) {
        this.questionRepository = questionRepository;
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

    public Question assignTopicsToQuestion(Long topic_id, Long question_id) {
        Question question = questionRepository.findById(question_id).orElse(null);
        Topic topic = topicRepository.findById(topic_id).orElse(null);

        if (question != null && topic != null) {
            Set<Topic> topicSet = question.getTopicSet();
            if (topicSet == null) {
                topicSet = new HashSet<>();
            }
            topicSet.add(topic);
            question.setTopicSet(topicSet);

            // Update the inverse side of the relationship
            Set<Question> questionSet = topic.getQuestionsSet();
            if (questionSet == null) {
                questionSet = new HashSet<>();
            }
            questionSet.add(question);
            topic.setQuestionsSet(questionSet);

            return questionRepository.save(question);
        } else {
            throw new IllegalArgumentException("Question or Topic not found");
        }
    }

}
