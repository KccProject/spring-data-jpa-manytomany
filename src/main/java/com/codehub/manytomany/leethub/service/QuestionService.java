package com.codehub.manytomany.leethub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codehub.manytomany.leethub.model.Difficulty;
import com.codehub.manytomany.leethub.model.Platform;
import com.codehub.manytomany.leethub.model.Question;
import com.codehub.manytomany.leethub.model.Topic;
import com.codehub.manytomany.leethub.model.User;
import com.codehub.manytomany.leethub.repository.QuestionRepository;
import com.codehub.manytomany.leethub.repository.TopicRepository;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final TopicRepository topicRepository;
    private final PlatformService platformService;
    private final DifficultyService difficultyService;

    private final UserService userService;

    @Autowired
    public QuestionService(QuestionRepository questionRepository,
            TopicRepository topicRepository, PlatformService platformService, DifficultyService difficultyService,
            UserService userService) {
        this.questionRepository = questionRepository;
        this.topicRepository = topicRepository;
        this.platformService = platformService;
        this.difficultyService = difficultyService;
        this.userService = userService;

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

    public Question addTopicToQuestion(Long questionId, Long topicId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Optional<Topic> optionalTopic = topicRepository.findById(topicId);

        if (optionalQuestion.isPresent() && optionalTopic.isPresent()) {
            Question question = optionalQuestion.get();
            Topic topic = optionalTopic.get();

            // Check if the association already exists to avoid duplicates
            if (!question.getTopicsSet().contains(topic)) {
                question.getTopicsSet().add(topic);
                questionRepository.save(question);

                // Bidirectional association: Add the question to the topic
                if (!topic.getQuestionsSet().contains(question)) {
                    topic.getQuestionsSet().add(question);
                    topicRepository.save(topic);
                }

                return question;
            } else {
                // Handle case where the association already exists
                return null;
            }
        } else {
            // Handle case where Question or Topic not found
            return null;
        }
    }

    public Question addDifficultyToQuestion(Long questionId, Long difficultyId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Optional<Difficulty> optionalDifficulty = difficultyService.getDifficultyById(difficultyId);

        if (optionalQuestion.isPresent() && optionalDifficulty.isPresent()) {
            Question question = optionalQuestion.get();
            Difficulty difficulty = optionalDifficulty.get();

            // Check if the association already exists to avoid duplicates
            if (question.getDifficulty() == null || !question.getDifficulty().equals(difficulty)) {
                question.setDifficulty(difficulty);
                return questionRepository.save(question);
            } else {
                // Handle case where the association already exists
                return null;
            }
        } else {
            // Handle case where Question or Difficulty not found
            return null;
        }
    }

    public Question addPlatformToQuestion(Long questionId, Long platformId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Optional<Platform> optionalPlatform = platformService.getPlatformById(platformId);

        if (optionalQuestion.isPresent() && optionalPlatform.isPresent()) {
            Question question = optionalQuestion.get();
            Platform platform = optionalPlatform.get();

            // Check if the association already exists to avoid duplicates
            if (question.getPlatform() == null || !question.getPlatform().equals(platform)) {
                question.setPlatform(platform);
                return questionRepository.save(question);
            } else {
                // Handle case where the association already exists
                return null;
            }
        } else {
            // Handle case where Question or Platform not found
            return null;
        }
    }

    public Question addUserToQuestion(Long questionId, Long userId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Optional<User> optionalUser = userService.getUserById(userId);

        if (optionalQuestion.isPresent() && optionalUser.isPresent()) {
            Question question = optionalQuestion.get();
            User user = optionalUser.get();

            // Check if the association already exists to avoid duplicates
            if (!question.getUsers().contains(user)) {
                question.getUsers().add(user);
                return questionRepository.save(question);
            } else {
                // Handle case where the association already exists
                return null;
            }
        } else {
            // Handle case where Question or User not found
            return null;
        }
    }

    // public Question addAnswerToQuestion(Long questionId, Long answerId) {
    // Optional<Question> optionalQuestion =
    // questionRepository.findById(questionId);
    // Optional<Answer> optionalAnswer = answerService.getAnswerById(answerId);

    // if (optionalQuestion.isPresent() && optionalAnswer.isPresent()) {
    // Question question = optionalQuestion.get();
    // Answer answer = optionalAnswer.get();

    // // Check if the association already exists to avoid duplicates
    // if (!question.getAnswers().contains(answer)) {
    // question.getAnswers().add(answer);
    // return questionRepository.save(question);
    // } else {
    // // Handle case where the association already exists
    // return null;
    // }
    // } else {
    // // Handle case where Question or Answer not found
    // return null;
    // }
    // }
}
