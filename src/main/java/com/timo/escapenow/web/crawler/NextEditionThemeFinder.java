package com.timo.escapenow.web.crawler;

import com.timo.escapenow.web.dto.ThemeInfo;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 넥스트에디션 매장의 테마 정보 크롤러
 */
@Slf4j
public class NextEditionThemeFinder extends ThemeFinder {

    private final String CLASS_NAME_OF_THEME = "white-page-content";
    private final String CLASS_NAME_OF_AVAILAVLE_RESERVATION = "res-true";

    private final String ELEMENT_OF_TITLE = "h2";
    private final String ELEMENT_OF_TIME = "span";

    @Override
    protected List<ThemeInfo> crawlingThemes(Document document) {

        Elements themeElements = document.getElementsByClass(CLASS_NAME_OF_THEME);
        log.info("테마 정보를 가진 HTML 엘리먼트 획득");

        List<ThemeInfo> themeInfoList = new ArrayList<>();

        for (Element element : themeElements) {
            //제목
            Elements titleElement = element.getElementsByTag(ELEMENT_OF_TITLE);
            String title = titleElement.size() > 0 ? titleElement.get(0).text() : "";

            //시간
            Elements timeElements = element.getElementsByClass(CLASS_NAME_OF_AVAILAVLE_RESERVATION);
            List<String> availableTimes = timeElements
                    .stream()
                    .map(e -> e.getElementsByTag(ELEMENT_OF_TIME).get(0).text())
                    .collect(Collectors.toList());

            if (!availableTimes.isEmpty()) {
                themeInfoList.add(new ThemeInfo(title, availableTimes));
            }
        }


        return themeInfoList;
    }
}
