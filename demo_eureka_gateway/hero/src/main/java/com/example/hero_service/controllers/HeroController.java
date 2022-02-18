package com.example.hero_service.controllers;

import com.example.hero_service.dto.HeroDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hero")
public class HeroController {

    @GetMapping("/check")
    public ResponseEntity<String> checkStatus() {
        return ResponseEntity.ok("Hero Service is ready!");
    }

    @PostMapping("/add")
    public ResponseEntity<HeroDto> addHero(@RequestBody final HeroDto heroDto) {
        return ResponseEntity.ok(heroDto);
    }
}
