package com.example.demo_docker.controllers;

import java.util.List;
import java.util.Optional;
import com.example.demo_docker.entities.Settings;
import com.example.demo_docker.services.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/settings")
public class SettingsCustom {

  @Autowired
  private SettingsService settings;

  @GetMapping("")
  public List<Settings> getAll() {
    return this.settings.findAllSettings();
  }

  @GetMapping("/new")
  public ResponseEntity<String> create(
    @RequestParam("name") String name,
    @RequestParam("value") String value
  ) {
    return this.settings.createSetting(name, value)
      ? ResponseEntity.ok("OK")
      : ResponseEntity.badRequest().body("Already exists");
  }

  @GetMapping("/set")
  public ResponseEntity<String> update(
    @RequestParam("name") String name,
    @RequestParam("value") String value
  ) {
    return this.settings.updateSetting(name, value)
      ? ResponseEntity.ok("OK")
      : ResponseEntity.notFound().build();
  }

  @GetMapping("/{name}/{value}")
  public ResponseEntity<String> createOrUpdate(
    @PathVariable("name") String name,
    @PathVariable("value") String value
  ) {

    return this.settings.createSetting(name, value) || this.settings.updateSetting(name, value)
      ? ResponseEntity.ok("OK")
      : ResponseEntity.badRequest().build();
  }

  @GetMapping("/delete")
  public ResponseEntity<String> delete(@RequestParam("name") String name) {
    return this.settings.deleteSetting(name)
      ? ResponseEntity.ok("OK")
      : ResponseEntity.notFound().build();
  }

  @GetMapping("/{name}")
  public ResponseEntity<Settings> find(@PathVariable("name") String name) {
    final Optional<Settings> found = this.settings.findOneSetting(name);
    return found.isPresent()
      ? ResponseEntity.ok(found.get())
      : ResponseEntity.notFound().build();
  }
}
