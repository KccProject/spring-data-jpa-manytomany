package com.codehub.manytomany.leethub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codehub.manytomany.leethub.entity.Platform;


public interface PlatformRepository extends JpaRepository<Platform,Long>{
    
}