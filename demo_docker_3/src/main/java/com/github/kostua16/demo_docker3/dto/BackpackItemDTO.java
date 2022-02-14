package com.github.kostua16.demo_docker3.dto;

import com.github.kostua16.demo_docker3.entities.Hero;
import com.github.kostua16.demo_docker3.entities.Item;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
public class BackpackItemDTO {

    private long id;
    private long item;
    private int count = 1;
    private int hero;

}
