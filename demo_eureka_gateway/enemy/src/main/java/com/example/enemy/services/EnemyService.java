package com.example.enemy.services;

import com.example.common.dto.EnemyDTO;
import com.example.enemy.entities.Enemy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EnemyService {

    public ResponseEntity<EnemyDTO> createEnemy(final EnemyDTO enemyDTO) {
        final Enemy enemy = Enemy
            .builder()
            .name(enemyDTO.getName())
            .attribute(enemyDTO.getAttribute())
            .build();

        // todo: save to db
        log.info("Enemy {} has been created!", enemy);

        return ResponseEntity.ok(enemyDTO);
    }
}
