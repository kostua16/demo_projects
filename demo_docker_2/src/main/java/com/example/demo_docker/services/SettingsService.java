package com.example.demo_docker.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import com.example.demo_docker.entities.Settings;
import com.example.demo_docker.jpa.SettingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingsService {
  @Autowired
  private SettingsRepo settings;

  @Autowired
  private MetricsService metrics;

  @Autowired
  private LogService logService;

  @Transactional
  public List<Settings> findAllSettings() {
    final List<Settings> all = this.settings.findAll();
    this.metrics.increaseMetric("settingsGetCount");
    return all;
  }

  @Transactional
  public Optional<Settings> findOneSetting(String name) {
    final Optional<Settings> found = this.settings.findById(name);
    this.metrics.increaseMetric("settingsFindCount");
    return found;
  }

  @Transactional
  public boolean createSetting(String name, String value) {
    Optional<Settings> found = this.settings.findById(name);
    final boolean result;
    if (found.isPresent()) {
      result = false;
    } else {
      this.settings.save(new Settings(name, value));
      this.metrics.increaseMetric("settingsCreateCount");
      this.metrics.increaseMetric("settingsCount");
      this.logService.log(
        SettingsService.class.getName(),
        "Setting `%s` created and set to `%s`", name, value
      );
      result = true;
    }
    return result;
  }

  @Transactional
  public boolean updateSetting(String name, String value) {
    Optional<Settings> found = this.settings.findById(name);
    final boolean result;
    if (found.isPresent()) {
      final Settings item = found.get();
      item.setValue(value);
      this.settings.save(item);
      this.metrics.increaseMetric("settingsModifyCount");
      this.logService.log(
        SettingsService.class.getName(),
        "Setting `%s` set to `%s`", name, value
      );
      result = true;
    } else {
      result = false;
    }
    return result;
  }

  @Transactional
  public boolean deleteSetting(String name) {
    Optional<Settings> found = this.settings.findById(name);
    final boolean result;
    if (found.isPresent()) {
      this.settings.delete(found.get());
      result = true;
      this.metrics.increaseMetric("settingsDeleteCount");
      this.metrics.decreaseMetric("settingsCount");
      this.logService.log(
        SettingsService.class.getName(),
        "Setting `%s` deleted", name
      );
    } else {
      result = false;
    }
    return result;
  }
}
