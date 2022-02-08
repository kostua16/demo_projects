package com.example.demo_docker.controllers;

import java.util.List;
import com.example.demo_docker.entities.LogDetails;
import com.example.demo_docker.entities.Metric;
import com.example.demo_docker.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
public class LogsController {

  @Autowired
  private LogService service;

  @GetMapping("")
  public List<LogDetails> listAllLogs() {
    return this.service.getLogDetails();
  }

  @GetMapping("/filter/{name}")
  public List<LogDetails> filterByName(@PathVariable("name") String name) {
    return this.service.filterByName(name);
  }

  @GetMapping("/clear")
  public ResponseEntity<String> clear() {
    this.service.clear();
    return ResponseEntity.ok("OK");
  }
}
