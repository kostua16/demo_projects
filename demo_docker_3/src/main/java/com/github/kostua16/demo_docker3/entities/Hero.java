package com.github.kostua16.demo_docker3.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Hero {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @OneToMany(mappedBy="hero", cascade = {CascadeType.ALL})
    private Set<BackpackItem> backpackItem;

    @Column
    private int hp = 100;

    @Column
    private int maxHp = 100;

    @Column
    @Version
    private long version = 0;

    @Column
    private int level = 1;

    @Column
    private int experience = 0;

    public Hero(String name) {
        this.name = name;
    }
}
