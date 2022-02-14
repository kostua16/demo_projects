package com.github.kostua16.demo_docker3.controllers;

import com.github.kostua16.demo_docker3.dto.BackpackItemDTO;
import com.github.kostua16.demo_docker3.dto.EnemyDTO;
import com.github.kostua16.demo_docker3.dto.HeroDTO;
import com.github.kostua16.demo_docker3.entities.Enemy;
import com.github.kostua16.demo_docker3.entities.Hero;
import com.github.kostua16.demo_docker3.services.EnemyService;
import com.github.kostua16.demo_docker3.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enemy")
public class EnemyContoller {

    @Autowired
    private EnemyService enemy;

    @GetMapping("")
    public List<Enemy> getAll() {
        return this.enemy.findAllEnemy();
    }

    @PutMapping("")
    public Enemy borningSafely(@RequestBody EnemyDTO enemyDTO) {
        return this.enemy.add(enemyDTO.getName(),enemyDTO.getHp(),enemyDTO.getAttack(),enemyDTO.getExperience());
    }


    @PutMapping("{hero}/{item}/{count}")
    public ResponseEntity<String> AddItemPath(
        @PathVariable("hero") long enemy,
        @PathVariable("item") long item,
        @PathVariable("count") int count
    ) {
        return this.enemy.addItem(enemy,item,count)
            ? ResponseEntity.ok("OK")
            : ResponseEntity.notFound().build();
    }



}
