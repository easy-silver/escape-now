package com.timo.escapetimetable.parser;

import com.timo.escapetimetable.dto.ThemeInfo;

import java.util.List;

public interface Parser {

    List<ThemeInfo> getThemesWithAvailableTimetable(String url);

}
