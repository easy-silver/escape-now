package com.timo.escapetimetable.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter @Setter
public class ThemeInfo {

    //테마 제목
    private String title;

    //예약 가능한 테마 시간
    private List<String> times = new ArrayList<>();

}
