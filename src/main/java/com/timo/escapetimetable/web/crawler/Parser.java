package com.timo.escapetimetable.web.crawler;

import com.timo.escapetimetable.web.dto.ThemeInfo;

import java.util.List;

public interface Parser {

    List<ThemeInfo> getThemesWithAvailableTimetable(String url);

}
