package com.github.kostua16.demo_docker3.services;

import com.github.kostua16.demo_docker3.entities.LogDetails;
import com.github.kostua16.demo_docker3.jpa.LogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogRepo logs;

    @Transactional
    public void log(String service, String details) {
        this.logs.save(new LogDetails(service, details));
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
