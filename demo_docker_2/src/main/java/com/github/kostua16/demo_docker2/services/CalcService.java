package com.github.kostua16.demo_docker2.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.github.kostua16.demo_docker2.dto.MatrixDTO;
import com.github.kostua16.demo_docker2.entities.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalcService {

    private static final String INC_NAME = "increment";

    private static final int INC_DEF = 1;

    @Autowired
    private MetricsService metricsService;

    @Autowired
    private SettingsService settingsService;

    protected int getIncrement() {
        return this.settingsService
            .findOneSetting(CalcService.INC_NAME)
            .map(Settings::getValue)
            .map(Integer::parseInt)
            .orElse(CalcService.INC_DEF);
    }

    public List<Integer> incrementClassic(List<Integer> input) {
        final int increment = this.getIncrement();
        return metricsService.trackDuration(
            CalcService.class,
            String.format("calc-increment(x%s)-classic", input.size()),
            () -> {
                final List<Integer> result = new ArrayList<>();
                for (Integer integer : input) {
                    result.add(integer + increment);
                }
                return result;
            }
        );
    }

    public List<Integer> incrementLambda(List<Integer> input) {
        final int increment = this.getIncrement();
        return metricsService.trackDuration(
            CalcService.class,
            String.format("calc-increment(x%s)-lambda", input.size()),
            () -> input.stream()
                .map(i -> i + increment)
                .collect(Collectors.toList())
        );
    }

    public List<String> convertClassic(List<Integer> input) {
        return metricsService.trackDuration(
            CalcService.class,
            String.format("calc-convert(x%s)-classic", input.size()),
            () -> {
                final List<String> result = new ArrayList<>();
                for (Integer integer : input) {
                    result.add(integer.toString());
                }
                return result;
            }
        );
    }

    public List<String> convertLambda(List<Integer> input) {
        return metricsService.trackDuration(
            CalcService.class,
            String.format("calc-convert(x%s)-lambda", input.size()),
            () -> input.stream()
                .map(Object::toString)
                .collect(Collectors.toList())
        );
    }

    public List<Integer> evenClassic(List<Integer> input) {
        return metricsService.trackDuration(
            CalcService.class,
            String.format("calc-even(x%s)-classic", input.size()),
            () -> {
                final List<Integer> result = new ArrayList<>();
                for (Integer integer : input) {
                    if ((integer % 2) == 0) {
                        result.add(integer);
                    }
                }
                return result;
            }
        );
    }

    public List<Integer> evenLambda(List<Integer> input) {
        return metricsService.trackDuration(
            CalcService.class,
            String.format("calc-even(x%s)-lambda", input.size()),
            () -> input.stream()
                .filter(i -> (i % 2) == 0)
                .collect(Collectors.toList())
        );
    }

    public List<String> complexClassic(List<Integer> input) {
        final int increment = this.getIncrement();
        return metricsService.trackDuration(
            CalcService.class,
            String.format("calc-complex(x%s)-classic", input.size()),
            () -> {
                final List<String> result = new ArrayList<>();
                for (Integer integer : input) {
                    int newValue = integer + increment;
                    if ((newValue % 2) == 0) {
                        result.add(Integer.toString(newValue));
                    }
                }
                return result;
            }
        );
    }

    public List<String> complexLambda(List<Integer> input) {
        final int increment = this.getIncrement();
        return metricsService.trackDuration(
            CalcService.class,
            String.format("calc-complex(x%s)-lambda", input.size()),
            () -> input.stream()
                .map(i -> i + increment)
                .filter(i -> (i % 2) == 0)
                .map(Object::toString)
                .collect(Collectors.toList())
        );
    }

    public MatrixDTO matrixMultiplyClassic(MatrixDTO matrix) {
        return metricsService.trackDuration(
            CalcService.class,
            String.format("calc-matrix-mult(%sx%s)-classic", matrix.getVertical().size(),
                matrix.getHorizontal().size()),
            () -> {
                final MatrixDTO result = new MatrixDTO(matrix.getVertical(),
                    matrix.getHorizontal());
                final List<List<Integer>> body = new ArrayList<>();
                for (Integer vert : matrix.getVertical()) {
                    List<Integer> row = new ArrayList<>();
                    for (Integer horiz : matrix.getHorizontal()) {
                        row.add(vert * horiz);
                    }
                    body.add(row);
                }
                result.setBody(body);
                return result;
            }
        );
    }

    public MatrixDTO matrixMultiplyLambda(MatrixDTO matrix) {
        return metricsService.trackDuration(
            CalcService.class,
            String.format("calc-matrix-mult(%sx%s)-lambda", matrix.getVertical().size(), matrix.getHorizontal().size()),
            () -> new MatrixDTO(
                matrix.getVertical(),
                matrix.getHorizontal(),
                matrix.getVertical().stream()
                    .map(v -> matrix.getHorizontal().stream().map(h -> h * v).collect(Collectors.toList()))
                    .collect(Collectors.toList())
            )
        );
    }


}
