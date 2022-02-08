package com.example.demo_docker.entities;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LogDetails {

  @Id
  @GeneratedValue
  private long id;

  @Column
  private String moduleId;

  @Column
  private String details;

  @Column
  private Timestamp datetime;

  public LogDetails(long id, String moduleId, String details) {
    this.id = id;
    this.moduleId = moduleId;
    this.details = details;
    this.datetime = new Timestamp(System.currentTimeMillis());
  }

  public LogDetails(String moduleId, String details) {
    this(Long.MIN_VALUE, moduleId, details);
  }

  public LogDetails() {
    this("default", "");
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getModuleId() {
    return moduleId;
  }

  public void setModuleId(String moduleId) {
    this.moduleId = moduleId;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public Timestamp getDatetime() {
    return datetime;
  }

  public void setDatetime(Timestamp datetime) {
    this.datetime = datetime;
  }
}
