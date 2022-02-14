package com.github.kostua16.demo_docker3.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class BackpackItem {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "item", referencedColumnName = "id")
    private Item item;


    @Column
    @Version
    private long version = 0;

    @Column
    private int count = 1;

    @Column(name="hero")
    private long hero;

    public BackpackItem(Item item, int count, long hero) {
        this.item = item;
        this.count = count;
        this.hero = hero;
    }
}
