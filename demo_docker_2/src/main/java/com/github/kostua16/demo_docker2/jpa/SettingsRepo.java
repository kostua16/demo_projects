package com.github.kostua16.demo_docker2.jpa;

import com.github.kostua16.demo_docker2.entities.Settings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SettingsRepo extends JpaRepository<Settings, String> {

}
