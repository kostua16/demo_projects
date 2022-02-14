package com.github.kostua16.demo_docker3.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class LootItem {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "item", referencedColumnName = "id")
    private Item item;

    @Column
    private int count = 1;

    @Column
    private long enemy;

    public LootItem(Item item, int count, long enemy) {
        this.item = item;
        this.count = count;
        this.enemy = enemy;
    }

}
