package com.github.kostua16.demo_docker3.jpa;

import com.github.kostua16.demo_docker3.entities.LogDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepo extends JpaRepository<LogDetails, Long> {

    List<LogDetails> findByModuleIdContaining(String moduleId);
}
