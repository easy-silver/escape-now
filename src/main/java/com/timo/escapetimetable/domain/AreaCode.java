package com.timo.escapetimetable.domain;

import lombok.Getter;

@Getter
public enum AreaCode {
    GN("강남"),
    HD("홍대")
    ;

    private String title;

    AreaCode(String title) {
        this.title = title;
    }

}
