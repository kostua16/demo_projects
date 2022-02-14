package com.github.kostua16.demo_docker3.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private int attack = 0;

    @Column
    private int heal = 0;

    @Column
    private int armor = 0;

    public Item(String name, int attack, int heal, int armor) {
        this.name = name;
        this.attack = attack;
        this.heal = heal;
        this.armor = armor;
    }
}
