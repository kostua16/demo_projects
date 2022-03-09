package com.example.common.clients.enemy;

import com.example.common.dto.EnemyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ENEMY", path = "enemy")
public interface EnemyService {

    @GetMapping("/check")
    ResponseEntity<String> checkHealth();

    @PostMapping("/add")
    ResponseEntity<EnemyDTO> createEnemy(@RequestBody final EnemyDTO enemyDTO);

}
