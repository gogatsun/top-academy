package org.top.applicationsquare.service;

import org.springframework.stereotype.Service;
import org.top.applicationsquare.message.InputMessage;
import org.top.applicationsquare.message.OutputMessage;

@Service
public class StandartSolver implements Solver{

    public OutputMessage solve(InputMessage input) {
            Double radius = input.getRadius();
            if (radius == null) {
                throw new IllegalArgumentException("Radius is null!");
            }
            if (radius > 0.0) {
                Double square = Math.PI * radius * radius;
                Double perimeter = 2 * Math.PI * radius;
                return new OutputMessage(radius, perimeter, square);
            } else {
                throw new IllegalArgumentException("The radius cannot be less than or equal to 0");
            }
    }

}
