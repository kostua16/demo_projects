package com.github.kostua16.demo_docker2.jpa;

import java.util.List;
import com.github.kostua16.demo_docker2.entities.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricsRepository extends JpaRepository<Metric, String> {

    List<Metric> findByNameContaining(String name);
}
