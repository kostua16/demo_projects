package com.example.demo_docker.jpa;

import java.util.List;
import com.example.demo_docker.entities.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricsRepository extends JpaRepository<Metric, String> {
  List<Metric> findByNameContaining(String name);
}
