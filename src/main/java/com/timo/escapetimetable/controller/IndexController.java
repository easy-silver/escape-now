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
    @GetMapping("/{area}/shops")
    public String shopsInArea(@PathVariable String area, Model model) {
        model.addAttribute("area", area);
        model.addAttribute("shops", service.getShopListInArea(area));

        return "shops";
    }

    /**
     * 매장의 해당 지역 지점 조회
     *
     * @param area
     * @param shopId
     * @param model
     * @return
     */
    @GetMapping("/{area}/shops/{shopId}/branches")
    public String branchesInShop(@PathVariable String area, @PathVariable Long shopId, Model model) {
        model.addAttribute("branches", service.getBranchListInShop(area, shopId));
        model.addAttribute("area", area);

        return "branches";
    }

    /**
     * 해당 지점의 예약 가능한 테마 목록 조회
     *
     * @param area
     * @param shopId
     * @param branchId
     * @param model
     * @return
     */
    @GetMapping("/{area}/shops/{shopId}/branches/{branchId}")
    public String themesAndTimetableInBranch(@PathVariable String area, @PathVariable Long shopId,
                                             @PathVariable Long branchId, Model model) {

        model.addAttribute("response", service.getThemesAndTimetable(branchId));

        return "themes";
    }

}
