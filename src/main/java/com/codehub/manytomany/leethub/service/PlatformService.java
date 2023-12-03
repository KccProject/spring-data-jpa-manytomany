package com.codehub.manytomany.leethub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codehub.manytomany.leethub.entity.Platform;
import com.codehub.manytomany.leethub.repository.PlatformRepository;

@Service
public class PlatformService {
    private final PlatformRepository platformRepository;

    @Autowired
    public PlatformService(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    public Platform savePlatform(Platform platform) {
        return platformRepository.save(platform);
    }

    public List<Platform> getAllPlatform() {
        return platformRepository.findAll();
    }

    public Optional<Platform> getPlatformById(Long platform_id) {
        return platformRepository.findById(platform_id);
    }

    public void deletePlatform(Long platform_id) {
        platformRepository.deleteById(platform_id);
    }

}
