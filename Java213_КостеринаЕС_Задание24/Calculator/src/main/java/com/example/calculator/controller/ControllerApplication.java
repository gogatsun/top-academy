package com.example.calculator.controller;

import com.example.calculator.service.Circle;
import com.example.calculator.service.Solver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ControllerApplication {
    private final Solver solver;

    public ControllerApplication(Solver solver) {
        this.solver = solver;
    }

    @GetMapping("")
    public String index(Model model) {
        Circle nullCircle = new Circle(0.0);
        model.addAttribute("circle", nullCircle);
        return "index";
    }

    @PostMapping("")
    public String calc(Circle circle, Model model) {
        circle.setDiameter(solver.diameter(circle.getRadius()));
        model.addAttribute("diameter", circle.getDiameter());

        circle.setPerimeter(solver.perimeter(circle.getRadius()));
        model.addAttribute("perimeter", circle.getPerimeter());

        circle.setArea(solver.area(circle.getRadius()));
        model.addAttribute("area", circle.getArea());

        model.addAttribute("circle", circle);
        return "index";
    }

}
