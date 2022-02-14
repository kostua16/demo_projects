package com.github.kostua16.demo_docker3.controllers;

import com.github.kostua16.demo_docker3.dto.ItemDTO;
import com.github.kostua16.demo_docker3.entities.Item;
import com.github.kostua16.demo_docker3.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/battle")
public class BattleContoller {

    @Autowired
    private ItemService items;

    @GetMapping("")
    public List<Item> getAll() {
        return this.items.findAllItem();
    }

    @PutMapping("")
    public Item add(@RequestBody ItemDTO newItem) {
        return this.items.add(
            newItem.getName(),
            newItem.getAttack(),
            newItem.getHeal(),
            newItem.getArmor());
    }


}
