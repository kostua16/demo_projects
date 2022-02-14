package com.github.kostua16.demo_docker3.jpa;

import com.github.kostua16.demo_docker3.entities.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HeroRepo extends JpaRepository<Hero, Long> {

//    @Query(value = "SELECT h FROM Hero h WHERE h.hp = ?1")
    @Query(value = "SELECT h FROM HERO h WHERE h.HP = ?1 and h.maxHp = ?2 and h.name = ?3", nativeQuery = true)
//    @Query(value = "SELECT h FROM HERO h WHERE h.HP = 55 and h.maxHp = 100 and h.name = 'Maksim'  ", nativeQuery = true)
    List<Hero> selectValueHP(int hp, int maxhp, String name); //55 100 Maksim
}
