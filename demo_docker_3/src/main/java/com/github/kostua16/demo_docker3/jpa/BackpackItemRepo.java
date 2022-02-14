package com.github.kostua16.demo_docker3.jpa;

import com.github.kostua16.demo_docker3.entities.BackpackItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BackpackItemRepo extends JpaRepository<BackpackItem, Long> {

}
