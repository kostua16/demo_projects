package com.github.kostua16.demo_docker3.dto;

import com.github.kostua16.demo_docker3.entities.BackpackItem;
import lombok.Getter;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
public class HeroDTO {

    private long id;
    private String name;
    private List<BackpackItem> backpackItem;
    private int hp;
    private int maxHp;
    private int level;
    private int experience;

}
