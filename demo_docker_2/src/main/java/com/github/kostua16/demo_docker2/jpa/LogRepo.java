package com.github.kostua16.demo_docker2.jpa;

import java.util.List;
import com.github.kostua16.demo_docker2.entities.LogDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepo extends JpaRepository<LogDetails, Long> {

    List<LogDetails> findByModuleIdContaining(String moduleId);
}
