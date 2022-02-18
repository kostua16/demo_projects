package com.example.other.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("other")
public class OtherController {

    @GetMapping("check")
    public ResponseEntity<String> checkHealth() {
        return ResponseEntity.ok("Other Service is ready!");
    }
}
