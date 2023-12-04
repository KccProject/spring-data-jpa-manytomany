package com.codehub.manytomany.leethub.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codehub.manytomany.leethub.model.Difficulty;
import com.codehub.manytomany.leethub.service.DifficultyService;

@RestController
@RequestMapping("/api/difficulty")
public class DifficultyController {
    private final DifficultyService difficultyService;

    @Autowired
    public DifficultyController(DifficultyService difficultyService) {
        this.difficultyService = difficultyService;
    }

    @PostMapping("/save")
    public Difficulty saveDifficulty(@RequestBody Difficulty difficulty) {
        return difficultyService.saveDifficulty(difficulty);
    }

    @DeleteMapping("/{difficulty_id}")
    public void deleteDifficulty(@PathVariable Long difficulty_id) {
        difficultyService.deleteDifficulty(difficulty_id);
    }

    @GetMapping
    public List<Difficulty> getAllDifficulty() {
        return difficultyService.getAllDifficulty();
    }

    @GetMapping("/{difficulty_id}")
    public Difficulty getDifficultyById(@PathVariable Long difficulty_id) {
        Optional<Difficulty> difficulty = difficultyService.getDifficultyById(difficulty_id);
        if (difficulty.isPresent()) {
            return difficulty.get();
        } else {
            return new Difficulty();
        }

    }
}