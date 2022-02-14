package com.github.kostua16.demo_docker3.dto;

import com.github.kostua16.demo_docker3.entities.BackpackItem;
import lombok.Getter;

import javax.persistence.Column;
import java.util.List;

@Getter
public class ItemDTO {

    private long id;
    private String name;
    private int attack = 0;
    private int heal = 0;
    private int armor = 0;

}
