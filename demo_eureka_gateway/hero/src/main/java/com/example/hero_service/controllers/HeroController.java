package com.example.hero_service.controllers;

import com.example.common.dto.HeroDTO;
import com.example.hero_service.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hero")
public class HeroController {

    private final HeroService heroService;

    @Autowired
    public HeroController(final HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("/check")
    public ResponseEntity<String> checkStatus() {
        return ResponseEntity.ok("Hero Service is ready!");
    }

    @PostMapping("/add")
    public ResponseEntity<HeroDTO> addHero(@RequestBody final HeroDTO heroDto) {
        return heroService.createHero(heroDto);
    }
}
