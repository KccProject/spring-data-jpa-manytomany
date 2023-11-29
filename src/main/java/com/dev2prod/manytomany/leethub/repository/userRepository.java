package com.dev2prod.manytomany.leethub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev2prod.manytomany.leethub.entity.User;

public interface userRepository extends JpaRepository<User,Long>{
    
}
