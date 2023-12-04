// QuestionTopicMappingService.java
package com.codehub.manytomany.leethub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codehub.manytomany.leethub.model.Question;
import com.codehub.manytomany.leethub.model.QuestionTopicMapping;
import com.codehub.manytomany.leethub.model.Topic;
import com.codehub.manytomany.leethub.repository.QuestionTopicMappingRepository;

@Service
public class QuestionTopicMappingService {

    private final QuestionTopicMappingRepository questionTopicMappingRepository;

    @Autowired
    public QuestionTopicMappingService(QuestionTopicMappingRepository questionTopicMappingRepository) {
        this.questionTopicMappingRepository = questionTopicMappingRepository;
    }

    public void mapQuestionToTopic(Question question, Topic topic) {
        QuestionTopicMapping mapping = new QuestionTopicMapping();
        mapping.setQuestion(question);
        mapping.setTopic(topic);
        questionTopicMappingRepository.save(mapping);
    }
}
