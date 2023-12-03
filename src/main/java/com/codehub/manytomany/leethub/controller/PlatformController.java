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

import com.codehub.manytomany.leethub.entity.Platform;
import com.codehub.manytomany.leethub.service.PlatformService;

@RestController
@RequestMapping("/api/platform")
public class PlatformController {

    private final PlatformService platformService;

    @Autowired
    public PlatformController(PlatformService platformService) {
        this.platformService = platformService;
    }

    @PostMapping("/save")
    public Platform savePlatform(@RequestBody Platform platform) {
        return platformService.savePlatform(platform);
    }

    @GetMapping
    public List<Platform> getAllPlatform() {
        return platformService.getAllPlatform();
    }

    @GetMapping("/{platform_id}")
    public Platform getPlatformById(@PathVariable Long platform_id) {
        Optional<Platform> platform = platformService.getPlatformById(platform_id);
        if (platform.isPresent()) {
            return platform.get();
        } else {
            return new Platform();
        }
    }

    @DeleteMapping("/delete/{platform_id}")
    public void deletePlatform(@PathVariable Long platform_id) {
        platformService.deletePlatform(platform_id);
    }

}
