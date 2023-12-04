package com.codehub.manytomany.leethub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codehub.manytomany.leethub.model.QuestionTopicMapping;

public interface QuestionTopicMappingRepository extends JpaRepository<QuestionTopicMapping, Long> {

}
