package com.github.kostua16.demo_docker3.services;

import com.github.kostua16.demo_docker3.entities.BackpackItem;
import com.github.kostua16.demo_docker3.entities.Hero;
import com.github.kostua16.demo_docker3.entities.Item;
import com.github.kostua16.demo_docker3.jpa.BackpackItemRepo;
import com.github.kostua16.demo_docker3.jpa.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BackpackItemService {

    @Autowired
    private BackpackItemRepo backpackItemService;

    @Autowired
    private MetricsService metrics;

    @Autowired
    private LogService logService;



    @Transactional
    public BackpackItem add(Item item, int count, long hero) {
        return backpackItemService.save(new BackpackItem(item,count,hero));
    }




}
