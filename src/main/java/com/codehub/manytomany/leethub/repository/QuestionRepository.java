package com.codehub.manytomany.leethub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codehub.manytomany.leethub.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}