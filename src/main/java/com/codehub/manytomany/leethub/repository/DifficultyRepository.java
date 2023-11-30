package com.codehub.manytomany.leethub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codehub.manytomany.leethub.entity.Difficulty;

public interface DifficultyRepository extends JpaRepository<Difficulty, Long>{
    
}