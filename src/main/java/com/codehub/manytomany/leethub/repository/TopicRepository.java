package com.codehub.manytomany.leethub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codehub.manytomany.leethub.entity.Topic;

public interface TopicRepository extends JpaRepository<Topic,Long>{
    
}