package com.github.kostua16.demo_docker2.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Metric {

    @Id
    private String name;

    private long value;

    private long max;

    public Metric(String name, long value, long max) {
        this.name = name;
        this.value = value;
        this.max = max;
    }

    public Metric(String name, long value) {
        this(name, value, Long.MAX_VALUE);
    }

    public Metric(String name) {
        this(name, 0);
    }

    public Metric() {
        this("default");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }
}
