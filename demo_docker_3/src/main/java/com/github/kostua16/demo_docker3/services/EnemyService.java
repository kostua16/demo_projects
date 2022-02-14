package com.github.kostua16.demo_docker3.services;

import com.github.kostua16.demo_docker3.entities.*;
import com.github.kostua16.demo_docker3.jpa.EnemyRepo;
import com.github.kostua16.demo_docker3.jpa.HeroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EnemyService {

    @Autowired
    private EnemyRepo enemyService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private MetricsService metrics;

    @Autowired
    private LogService logService;

    @Transactional
    public List<Enemy> findAllEnemy() {
        final List<Enemy> all = this.enemyService.findAll();
        this.metrics.increaseMetric("findAllEnemy");
        return all;
    }

    @Transactional
    public Enemy add(String name, int hp, int attack, int experience) {
        return enemyService.save(new Enemy(name,hp,attack,experience));
    }

    @Transactional
    public boolean addItem(long heroId, long itemId, int count){
        Optional<Enemy> enemy = enemyService.findById(heroId);
        Optional<Item> item = itemService.findById(itemId);
        final boolean result;
        if (enemy.isPresent() && item.isPresent()) {
            enemy.get().getLootItem().add(new LootItem(item.get(),count,enemy.get().getId()));
            enemyService.save(enemy.get());
            result = true;
        } else {
            result = false;
        }
        return result;
    }

}
