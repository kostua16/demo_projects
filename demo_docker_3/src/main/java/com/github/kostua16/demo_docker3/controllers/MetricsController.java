package com.github.kostua16.demo_docker3.controllers;

import com.github.kostua16.demo_docker3.entities.Metric;
import com.github.kostua16.demo_docker3.services.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/metrics")
public class MetricsController {

    @Autowired
    private MetricsService metricsService;

    @GetMapping("")
    public List<Metric> listAllMetrics() {
        return this.metricsService.getAllMetrics();
    }

    @GetMapping("/filter/{name}")
    public List<Metric> filterByName(@PathVariable("name") String name) {
        return this.metricsService.filterByName(name);
    }

    @GetMapping("/clear")
    public ResponseEntity<String> clear() {
        this.metricsService.clear();
        return ResponseEntity.ok("OK");
    }
}
