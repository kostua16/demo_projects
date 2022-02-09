package com.github.kostua16.demo_docker2.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixDTO {

    private List<Integer> vertical;

    private List<Integer> horizontal;

    private List<List<Integer>> body;

    public MatrixDTO(List<Integer> vertical, List<Integer> horizontal, List<List<Integer>> body) {
        this.setVertical(vertical);
        this.setHorizontal(horizontal);
        this.setBody(body);
    }

    public MatrixDTO(List<Integer> vertical, List<Integer> horizontal) {
        this(vertical, horizontal, new ArrayList<>());
    }

    public MatrixDTO() {
        this(new ArrayList<>(), new ArrayList<>());
    }

    public List<Integer> getVertical() {
        return Collections.unmodifiableList(vertical);
    }

    public void setVertical(List<Integer> vertical) {
        this.vertical = Optional.ofNullable(vertical)
            .map(List::stream)
            .orElseGet(Stream::empty)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }

    public List<Integer> getHorizontal() {
        return Collections.unmodifiableList(horizontal);
    }

    public void setHorizontal(List<Integer> horizontal) {
        this.horizontal = Optional.ofNullable(horizontal)
            .map(List::stream)
            .orElseGet(Stream::empty)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }

    public List<List<Integer>> getBody() {
        return Collections.unmodifiableList(body);
    }

    public void setBody(List<List<Integer>> body) {
        this.body = Optional.ofNullable(body)
            .map(List::stream)
            .orElseGet(Stream::empty)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }
}
