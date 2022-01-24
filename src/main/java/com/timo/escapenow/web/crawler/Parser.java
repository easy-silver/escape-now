package com.timo.escapenow.web.crawler;

import com.timo.escapenow.web.dto.ThemeInfo;

import java.util.List;

public interface Parser {

    List<ThemeInfo> getThemesWithAvailableTimetable(String url);

}
