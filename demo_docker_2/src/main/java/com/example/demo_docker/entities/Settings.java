package com.example.demo_docker.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Settings {

    @Column
    @Id
    private String name;

    @Column
    private String value;

    public Settings() {
        this("default", "default");
    }

    public Settings(String name, String value) {
        this.name = name;
        this.value = value;
    }
    

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

}
