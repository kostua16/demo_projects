package com.github.kostua16.demo_docker3.dto;

import com.github.kostua16.demo_docker3.entities.BackpackItem;
import lombok.Getter;

import javax.persistence.Column;
import java.util.List;

@Getter
public class EnemyDTO {

    private long id;
    private String name;
    private long enemy;
    private int hp = 10;
    private int attack = 1;
    private int experience = 10;

}
