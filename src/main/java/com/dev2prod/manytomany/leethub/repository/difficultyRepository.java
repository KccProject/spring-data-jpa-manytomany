package com.dev2prod.manytomany.leethub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev2prod.manytomany.leethub.entity.Difficulty;

public interface difficultyRepository extends JpaRepository<Difficulty, Long>{
    
}
