package com.example.springmvcexample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// контроллер - класс отвечающий за обработку входящих запросов
@Controller
public class ApplicationController {

    // http://localhost:8080
    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("info")
    public String info(Model model) {

        String pattern = "dd.MM.yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String currentTime = LocalDate.now().format(formatter);
        model.addAttribute("infoDate", currentTime);

        String infoOperationSystem = System.getProperty("os.name");
        model.addAttribute("infoOperationSystem", infoOperationSystem);

        String infoUserDir = System.getProperty("user.dir");
        model.addAttribute("infoUserDir", infoUserDir);

        String infoVersion = System.getProperty("java.runtime.version");
        model.addAttribute("infoVersion", infoVersion);

        String infoUserName = System.getProperty("user.name");
        model.addAttribute("infoUserName", infoUserName);


        // добавим значение текущего времени в модель представления
        return "info";
    }
}
