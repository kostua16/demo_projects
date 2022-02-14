package com.github.kostua16.demo_docker3.services;

import com.github.kostua16.demo_docker3.dto.HeroDTO;
import com.github.kostua16.demo_docker3.entities.BackpackItem;
import com.github.kostua16.demo_docker3.entities.Hero;
import com.github.kostua16.demo_docker3.entities.Item;
import com.github.kostua16.demo_docker3.jpa.BackpackItemRepo;
import com.github.kostua16.demo_docker3.jpa.HeroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HeroService {

    @Autowired
    private HeroRepo heroService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private MetricsService metrics;

    @Autowired
    private LogService logService;

    @Transactional
    public List<Hero> findAllHero() {
        final List<Hero> all = this.heroService.findAll();
        this.metrics.increaseMetric("findAllHero");
        return all;
    }

    @Transactional
    public Hero borningSafely(String name) {
        Optional<Hero> optionalHero = heroService.findById(1l);
        if(optionalHero.isPresent()){
            Hero hero = optionalHero.get();
            heroService.delete(hero);
            hero.setHp(50);
            heroService.save(hero);
        }


        return heroService.save(new Hero(name));
    }

    @Transactional
    public List<Hero> moreBorning(List<HeroDTO> newHero) {
        List<Hero> heros = new ArrayList<>(newHero.size());
        newHero.forEach(enemy -> {heros.add(new Hero(enemy.getName()));});
        heroService.saveAll(heros);
        return heros;
    }


    public Hero borning(String name) {
        Hero response = heroService.save(new Hero(name));
        heroService.flush();
        return response;
    }

    public Hero borningLong(String name) {
        return heroService.save(new Hero(name));
    }

    @Transactional
    public boolean addItem(long heroId, long itemId, int count){
        Optional<Hero> hero = heroService.findById(heroId);
        Optional<Item> item = itemService.findById(itemId);
        final boolean result;
        if (hero.isPresent() && item.isPresent()) {
            hero.get().getBackpackItem().add(new BackpackItem(item.get(),count,hero.get().getId()));
//            backpackItemService.add(item.get(),count,hero.get().getId());
            heroService.save(hero.get());
            result = true;
        } else {
            result = false;
        }
        return result;
    }

}
