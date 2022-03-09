package com.example.enemy.entities;

import com.example.common.dto.Attributes;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Enemy {
    private Long enemyId;
    private String name;
    private Attributes attribute;
    private Integer level;

    @Builder
    public Enemy(
        final Long enemyId,
        final String name,
        final Attributes attribute
    ) {
        this.enemyId = UUID.randomUUID().getLeastSignificantBits();
        this.name = name;
        this.attribute = attribute;
        this.level = (int) (Math.random() * 101) + 1;
    }
}
