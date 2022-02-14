package com.github.kostua16.demo_docker3.services;

import com.github.kostua16.demo_docker3.entities.Metric;
import com.github.kostua16.demo_docker3.jpa.MetricsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Supplier;

@Service
public class MetricsService {

    @Autowired
    private MetricsRepository metrics;

    @Autowired
    private LogService logService;

    @Transactional
    public void increaseMetric(String name) {
        Metric param = this.metrics.findById(name).orElse(new Metric(name));
        param.setValue(param.getValue() + 1);
        this.metrics.save(param);
        this.logService.log(
            MetricsService.class.getName(),
            "Metric `%s` increased to `%s`", name, param.getValue()
        );
    }

    @Transactional
    public void decreaseMetric(String name) {
        Metric param = this.metrics.findById(name).orElse(new Metric(name));
        param.setValue(param.getValue() - 1);
        this.metrics.save(param);
        this.logService.log(
            MetricsService.class.getName(),
            "Metric `%s` decreased to `%s`", name, param.getValue()
        );
    }

    @Transactional
    public <T> T trackDuration(String serviceName, String methodName, Supplier<T> code) {
        StopWatch watch = new StopWatch(methodName);
        watch.start();
        final T result = code.get();
        watch.stop();
        this.metrics.save(new Metric(methodName, watch.getTotalTimeNanos()));
        this.logService.log(
            serviceName,
            "Code `%s` executed in `%s` nano-seconds", methodName, watch.getTotalTimeNanos()
        );
        return result;
    }

    public void trackDuration(String serviceName, String methodName, Runnable code) {
        this.trackDuration(serviceName, methodName, () -> {
            code.run();
            return null;
        });
    }

    public void trackDuration(String methodName, Runnable code) {
        this.trackDuration(MetricsService.class.getName(), methodName, code);
    }

    public <T> T trackDuration(String methodName, Supplier<T> code) {
        return this.trackDuration(MetricsService.class.getName(), methodName, code);
    }

    public void trackDuration(Class<?> service, String methodName, Runnable code) {
        this.trackDuration(service.getName(), methodName, code);
    }

    public <T> T trackDuration(Class<?> service, String methodName, Supplier<T> code) {
        return this.trackDuration(service.getName(), methodName, code);
    }

    public List<Metric> getAllMetrics() {
        return this.metrics.findAll();
    }

    public List<Metric> filterByName(String name) {
        return this.metrics.findByNameContaining(name);
    }

    @Transactional
    public void clear() {
        this.metrics.deleteAll();
    }

}
