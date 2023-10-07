package org.top.applicationsquare;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.top.applicationsquare.message.ErrorMessage;
import org.top.applicationsquare.message.InputMessage;
import org.top.applicationsquare.message.Message;
import org.top.applicationsquare.service.Solver;

@RestController
public class ApplicationController {

    private final Solver solver;

    public ApplicationController(Solver solver) {
        this.solver = solver;
    }

    @GetMapping("")
    public String index() {
        return "Server is running!";
    }

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("circle/{radius}")
    public Message circle(@PathVariable Double radius) {
        try {
            InputMessage input = new InputMessage(radius);
            return solver.solve(input);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return new ErrorMessage(ex.getMessage());
        }
    }
}
