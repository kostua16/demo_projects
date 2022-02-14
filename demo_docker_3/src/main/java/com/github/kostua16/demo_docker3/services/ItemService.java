package com.github.kostua16.demo_docker3.services;

import com.github.kostua16.demo_docker3.entities.Item;
import com.github.kostua16.demo_docker3.jpa.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepo itemService;

    @Autowired
    private MetricsService metrics;

    @Autowired
    private LogService logService;

    @Transactional
    public List<Item> findAllItem() {
        final List<Item> all = this.itemService.findAll();
        this.metrics.increaseMetric("findAllItem");
        return all;
    }

    @Transactional
    public Item add(String name, int attack, int heal, int armor) {
        return itemService.save(new Item(
            name,
            attack,
            heal,
            armor
            )
        );
    }

    @Transactional
    public Optional<Item> findById(long item) {
        return itemService.findById(item);
    }



}
