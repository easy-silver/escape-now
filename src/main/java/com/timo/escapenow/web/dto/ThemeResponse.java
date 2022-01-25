package com.timo.escapenow.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class ThemeResponse {

    private String shop;

    private String branch;

    private List<ThemeInfo> themes;

    public ThemeResponse(String shop, String branch, List<ThemeInfo> themes) {
        this.shop = shop;
        this.branch = branch;
        this.themes = themes;
    }
}
