package com.example.demo_docker.jpa;

import java.util.List;
import com.example.demo_docker.entities.LogDetails;
import com.example.demo_docker.entities.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepo extends JpaRepository<LogDetails, Long> {
  List<LogDetails> findByModuleIdContaining(String moduleId);
}
