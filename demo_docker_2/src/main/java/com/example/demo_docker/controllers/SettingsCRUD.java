package com.example.demo_docker.controllers;

import java.util.List;
import java.util.Optional;


import com.example.demo_docker.entities.Settings;
import com.example.demo_docker.dto.SettingsDTO;

import com.example.demo_docker.services.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/settings/crud")
public class SettingsCRUD {

  @Autowired
  private SettingsService settings;

  @GetMapping("")
  public List<Settings> getAll() {
    return this.settings.findAllSettings();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Settings> find(@PathVariable("id") String id) {
    final Optional<Settings> found = this.settings.findOneSetting(id);
    return found.isPresent()
      ? ResponseEntity.ok(found.get())
      : ResponseEntity.notFound().build();
  }

  @PutMapping("")
  public ResponseEntity<String> crete(@RequestBody SettingsDTO newbie) {
    return this.settings.createSetting(newbie.getName(), newbie.getValue())
      ? ResponseEntity.ok("OK")
      : ResponseEntity.badRequest().body("Already exists");
  }

  @PostMapping("")
  public ResponseEntity<String> update(@RequestBody SettingsDTO item) {
    return this.settings.updateSetting(item.getName(), item.getValue())
      ? ResponseEntity.ok("OK")
      : ResponseEntity.notFound().build();
  }

  @DeleteMapping("")
  public ResponseEntity<String> delete(@RequestBody String name) {
    return this.settings.deleteSetting(name)
      ? ResponseEntity.ok("OK")
      : ResponseEntity.notFound().build();
  }
}
