package com.example.enemy.controllers;

import com.example.common.dto.EnemyDTO;
import com.example.enemy.services.EnemyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("enemy")
public class EnemyController {

    private final EnemyService enemyService;

    @Autowired
    public EnemyController(final EnemyService enemyService) {
        this.enemyService = enemyService;
    }

    @GetMapping("/check")
    public ResponseEntity<String> checkHealth() {
        System.out.println("Some operations");
        return ResponseEntity.ok("Enemy Service is ready!");
    }

    @PostMapping("/add")
    public ResponseEntity<EnemyDTO> createEnemy(final EnemyDTO enemyDTO) {
        return this.enemyService.createEnemy(enemyDTO);
    }
}
