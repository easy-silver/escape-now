package com.timo.escapetimetable.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class IndexController {

    @GetMapping("")
    public String index() {
        System.out.println("IndexController.index");
        return "index";
    }

    @GetMapping("/shops/{area}")
    public String shopsInArea(@PathVariable String area, Model model) {
        System.out.println("IndexController.shopsInArea");

        return "shops";
    }

}
