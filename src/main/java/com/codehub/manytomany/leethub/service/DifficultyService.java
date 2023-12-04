package com.codehub.manytomany.leethub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codehub.manytomany.leethub.model.Difficulty;
import com.codehub.manytomany.leethub.repository.DifficultyRepository;

@Service
public class DifficultyService {
    private final DifficultyRepository difficultyRepository;

    @Autowired
    public DifficultyService(DifficultyRepository difficultyRepository) {
        this.difficultyRepository = difficultyRepository;
    }

    public Difficulty saveDifficulty(Difficulty difficulty) {
        return difficultyRepository.save(difficulty);
    }

    public List<Difficulty> getAllDifficulty() {
        return difficultyRepository.findAll();
    }

    public Optional<Difficulty> getDifficultyById(Long difficulty_id) {
        return difficultyRepository.findById(difficulty_id);
    }

    public void deleteDifficulty(Long difficulty_id) {
        difficultyRepository.deleteById(difficulty_id);
    }

}
