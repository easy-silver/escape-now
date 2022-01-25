package com.timo.escapenow.service.crawler;

import com.timo.escapenow.web.dto.ThemeInfo;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class SecretGardenThemeFinder extends ThemeFinder {

    private final String CLASS_NAME_OF_THEME = "time_Area";
    private final String CLASS_NAME_OF_TITLE = "h3_theme";

    @Override
    protected List<ThemeInfo> crawlingThemes(Document document) {

        Elements themeElements = document.getElementsByClass(CLASS_NAME_OF_THEME);
        log.info("테마 정보를 가진 HTML 엘리먼트 획득");

        List<ThemeInfo> themeInfoList = new ArrayList<>();
        for (Element element : themeElements) {

            String title = element.getElementsByClass(CLASS_NAME_OF_TITLE).stream()
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("테마 제목 미발견"))
                    .text();

            Elements availableTimeElements = element.getElementsByClass("reserve_Time")
                    .stream()
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("시간표 미발견"))
                    .select("li > a:not(.end)");

            List<String> availableTimes = availableTimeElements.stream()
                    .map(e -> e.getElementsByClass("time").get(0).text())
                    .collect(Collectors.toList());

            if (!availableTimes.isEmpty()) {
                themeInfoList.add(new ThemeInfo(title, availableTimes));
            }
        }

        return themeInfoList;
    }
}
