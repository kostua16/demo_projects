package com.example.demo_docker.jpa;

import com.example.demo_docker.entities.Settings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SettingsRepo extends JpaRepository<Settings, String> {
}
