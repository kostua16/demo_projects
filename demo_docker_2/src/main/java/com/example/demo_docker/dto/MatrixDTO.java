package com.example.demo_docker.dto;

import java.util.ArrayList;
import java.util.List;

public class MatrixDTO {
  private List<Integer> vertical;
  private List<Integer> horizontal;
  private List<List<Integer>> body;

  public MatrixDTO(List<Integer> vertical, List<Integer> horizontal, List<List<Integer>> body) {
    this.vertical = vertical;
    this.horizontal = horizontal;
    this.body = body;
  }

  public MatrixDTO(List<Integer> vertical, List<Integer> horizontal) {
    this(vertical, horizontal, new ArrayList<>());
  }

  public MatrixDTO() {
    this(new ArrayList<>(), new ArrayList<>());
  }

  public List<Integer> getVertical() {
    return vertical;
  }

  public void setVertical(List<Integer> vertical) {
    this.vertical = vertical;
  }

  public List<Integer> getHorizontal() {
    return horizontal;
  }

  public void setHorizontal(List<Integer> horizontal) {
    this.horizontal = horizontal;
  }

  public List<List<Integer>> getBody() {
    return body;
  }

  public void setBody(List<List<Integer>> body) {
    this.body = body;
  }
}
