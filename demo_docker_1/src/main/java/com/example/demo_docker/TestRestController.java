package com.example.demo_docker;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class TestRestController {
  @GetMapping("/")
  public List<String> getAll() {
    final ArrayList<String> list = new ArrayList<>();
    list.add("first");
    list.add("second");
    return list;
  }

  @GetMapping("/1")
  public String getFirst() {
    return "first";
  }

  @GetMapping("/2")
  public String getSecond() {
    return "second";
  }
}
