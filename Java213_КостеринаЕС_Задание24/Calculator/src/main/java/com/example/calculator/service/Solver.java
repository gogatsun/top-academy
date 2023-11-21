package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class Solver implements ServiceSolver {

    @Override
    public Double diameter(Double radius) {
        return 2.0 * radius;
    }

    @Override
    public Double perimeter(Double radius) {
        return 2.0 * Math.PI * radius;
    }

    @Override
    public Double area(Double radius) {
        return Math.PI * radius * radius;
    }
}
