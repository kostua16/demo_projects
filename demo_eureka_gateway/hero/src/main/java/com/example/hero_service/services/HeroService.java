package com.example.hero_service.services;

import com.example.common.clients.enemy.EnemyService;
import com.example.common.dto.Attributes;
import com.example.common.dto.EnemyDTO;
import com.example.common.dto.HeroDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HeroService {

    private final EnemyService enemyService;

    @Autowired
    public HeroService(final EnemyService enemyService) {
        this.enemyService = enemyService;
    }

    public ResponseEntity<HeroDTO> createHero(final HeroDTO heroDto) {

        // todo: some operation with entity and db

        // call Enemy creation method (controller)
        final EnemyDTO enemyDTO = this.enemyService
            .createEnemy(new EnemyDTO("Opponent_" + heroDto.getName(), Attributes.STRENGTH))
            .getBody();

        log.info("EnemyDTO from feign client: {}", enemyDTO);

        return ResponseEntity.ok(heroDto);
    }
}
