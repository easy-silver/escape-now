package com.timo.escapetimetable.controller;

import com.timo.escapetimetable.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/")
@Controller
public class IndexController {

    private final IndexService service;

    @GetMapping("")
    public String index() {
        System.out.println("IndexController.index");
        return "index";
    }

    /**
     * 매장 목록 조회
     *
     * @param area
     * @param model
     * @return
     */
    @GetMapping("/shops/{area}")
    public String shopsInArea(@PathVariable String area, Model model) {
        model.addAttribute("shops", service.getShopListInArea(area));

        return "shops";
    }

}
