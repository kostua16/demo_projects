package com.github.kostua16.demo_docker3.controllers;

import com.github.kostua16.demo_docker3.dto.BackpackItemDTO;
import com.github.kostua16.demo_docker3.dto.HeroDTO;
import com.github.kostua16.demo_docker3.entities.Hero;
import com.github.kostua16.demo_docker3.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hero")
public class HeroContoller {

    @Autowired
    private HeroService heros;

    @GetMapping("")
    public List<Hero> getAll() {
        return this.heros.findAllHero();
    }

    @PutMapping("")
    public Hero borningSafely(@RequestBody HeroDTO newHero) {
        return this.heros.borningSafely(newHero.getName());
    }

    @PutMapping("borning")
    public Hero borning(@RequestBody HeroDTO newHero) {
        return this.heros.borning(newHero.getName());
    }

    @PutMapping("borningLong")
    public Hero borningLong(@RequestBody HeroDTO newHero) {
        return this.heros.borningLong(newHero.getName());
    }

    @PutMapping("more")
    public List<Hero> borningMassice(@RequestBody List<HeroDTO> newHero) {
        return this.heros.moreBorning(newHero);
    }

    @PutMapping("{hero}/{item}/{count}")
    public ResponseEntity<String> AddItemPath(
        @PathVariable("hero") long hero,
        @PathVariable("item") long item,
        @PathVariable("count") int count
    ) {
        return this.heros.addItem(hero,item,count)
            ? ResponseEntity.ok("OK")
            : ResponseEntity.notFound().build();
    }

    @PutMapping("addItem")
    public ResponseEntity<String> AddItem(@RequestBody BackpackItemDTO newBackpackItemDTO) {
        return this.heros.addItem(newBackpackItemDTO.getHero(), newBackpackItemDTO.getItem(), newBackpackItemDTO.getCount())
            ? ResponseEntity.ok("OK")
            : ResponseEntity.notFound().build();
    }


}
