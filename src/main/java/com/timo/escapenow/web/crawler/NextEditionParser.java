package com.timo.escapenow.web.crawler;

import com.timo.escapenow.web.dto.ThemeInfo;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class NextEditionParser implements Parser {

    @Override
    public List<ThemeInfo> getThemesWithAvailableTimetable(String url) {
        log.info("##### Jsoup Parser 시작");
        Connection connection = Jsoup.connect(url);
        log.info("URL 연결 성공");
        Document document = null;

        try {
            document = connection.get();
            log.info("전체 문서 획득");
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ThemeInfo> themeInfoList = new ArrayList<>();
        Elements themeElements = document.getElementsByClass("white-page-content");
        log.info("테마 정보 엘리먼트 획득");

        for (Element element : themeElements) {
            //제목
            Elements titleElement = element.getElementsByTag("h2");
            String title = titleElement.size() > 0 ? titleElement.get(0).text() : "";

            //시간
            Elements timeElements = element.getElementsByClass("res-true");
            List<String> availableTimes = timeElements
                    .stream()
                    .map(e -> e.getElementsByTag("span").get(0).text())
                    .collect(Collectors.toList());

            if (!availableTimes.isEmpty()) {
                themeInfoList.add(new ThemeInfo(title, availableTimes));
            }
        }

        log.info("##### Jsoup parser 종료");
        return themeInfoList;
    }

}
