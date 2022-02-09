package com.github.kostua16.demo_docker2.controllers;

import java.util.List;
import com.github.kostua16.demo_docker2.dto.MatrixDTO;
import com.github.kostua16.demo_docker2.services.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calc/classic")
public class CalcClassic {

    @Autowired
    private CalcService calc;

    @GetMapping(value = "/inc")
    public List<Integer> increment(@RequestBody List<Integer> input) {
        return this.calc.incrementClassic(input);

    }

    @GetMapping(value = "/conv")
    public List<String> convert(@RequestBody List<Integer> input) {
        return this.calc.convertClassic(input);
    }

    @GetMapping(value = "/even")
    public List<Integer> even(@RequestBody List<Integer> input) {
        return this.calc.evenClassic(input);
    }

    @GetMapping(value = "/complex")
    public List<String> complex(@RequestBody List<Integer> input) {
        return this.calc.complexClassic(input);
    }

    @GetMapping(value = "/matrixMultiply")
    public MatrixDTO matrixMultiply(@RequestBody MatrixDTO matrix) {
        return this.calc.matrixMultiplyClassic(matrix);
    }
}
