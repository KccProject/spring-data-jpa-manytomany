package com.codehub.manytomany.leethub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codehub.manytomany.leethub.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
