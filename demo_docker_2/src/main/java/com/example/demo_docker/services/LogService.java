package com.example.demo_docker.services;

import java.util.Formatter;
import java.util.List;
import javax.transaction.Transactional;
import com.example.demo_docker.entities.LogDetails;
import com.example.demo_docker.entities.Metric;
import com.example.demo_docker.jpa.LogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class LogService {
  @Autowired
  private LogRepo logs;

  @Transactional
  public void log(String service, String details) {
    this.logs.save( new LogDetails(service, details));
  }

  @Transactional
  public void log(String service, String format, Object... args) {
    this.log(service, String.format(format, args));
  }

  public List<LogDetails> getLogDetails() {
    return this.logs.findAll();
  }

  public List<LogDetails> filterByName(String name) {
    return this.logs.findByModuleIdContaining(name);
  }

  @Transactional
  public void clear() {
    this.logs.deleteAll();
  }
}
