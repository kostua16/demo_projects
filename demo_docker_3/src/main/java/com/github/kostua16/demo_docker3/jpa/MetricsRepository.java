package com.github.kostua16.demo_docker3.jpa;

import com.github.kostua16.demo_docker3.entities.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetricsRepository extends JpaRepository<Metric, String> {

    List<Metric> findByNameContaining(String name);
}
