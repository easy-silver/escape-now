package com.timo.escapenow.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter @Setter
public class ThemeResponse {

    private String shop;

    private String branch;

    private List<ThemeInfo> themes;

}
