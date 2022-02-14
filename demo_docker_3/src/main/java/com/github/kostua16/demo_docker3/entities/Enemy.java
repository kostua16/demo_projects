package com.github.kostua16.demo_docker3.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Enemy {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private int hp = 10;

    @Column
    private int attack = 1;

    @Column
    private int experience = 10;

    @OneToMany(mappedBy="enemy", cascade = {CascadeType.ALL})
    private Set<LootItem> lootItem;

    public Enemy(String name, int hp, int attack, int experience) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.experience = experience;
    }
}
