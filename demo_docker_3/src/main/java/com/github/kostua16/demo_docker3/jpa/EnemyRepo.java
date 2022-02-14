package com.github.kostua16.demo_docker3.jpa;

import com.github.kostua16.demo_docker3.entities.Enemy;
import com.github.kostua16.demo_docker3.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnemyRepo extends JpaRepository<Enemy, Long> {

}
