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

import com.codehub.manytomany.leethub.entity.Topic;
import com.codehub.manytomany.leethub.service.TopicService;

@RestController
@RequestMapping("/api/topic")
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping("/save")
    public Topic saveTopic(@RequestBody Topic topic) {
        return topicService.saveTopic(topic);
    }

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @DeleteMapping("/delete/{topic_id}")
    public void deleteTopic(@PathVariable Long topic_id) {
        topicService.deleteTopic(topic_id);
    }

    @GetMapping("/{topic_id}")
    public Topic getTopicById(@PathVariable Long topic_id) {
        Optional<Topic> to = topicService.getTopicById(topic_id);
        if (to.isPresent()) {
            Topic tp = to.get();
            return tp;
        } else {
            return new Topic();
        }
    }

}
