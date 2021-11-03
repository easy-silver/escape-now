package com.timo.escapetimetable.parser;

import com.timo.escapetimetable.dto.ThemeInfo;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NextEditionTableParser implements Parser {

    @Override
    public List<ThemeInfo> getThemesWithAvailableTimetable(String url) {
        Connection connection = Jsoup.connect(url);
        Document document = null;

        try {
            document = connection.get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ThemeInfo> themeInfoList = new ArrayList<>();
        Elements themeElements = document.getElementsByClass("white-page-content");

        for (Element element : themeElements) {
            ThemeInfo themeInfo = new ThemeInfo();

            //제목
            Elements titleElement = element.getElementsByTag("h2");
            String title = titleElement.size() > 0 ? titleElement.get(0).text() : "";

            //시간
            Elements timeElements = element.getElementsByClass("res-true");
            List<String> availableTimes = timeElements
                    .stream()
                    .map(e -> e.getElementsByTag("span").get(0).text())
                    .collect(Collectors.toList());

            themeInfo.setTitle(title);
            themeInfo.setTimes(availableTimes);
            if (availableTimes.size() > 0) {
                themeInfoList.add(themeInfo);
            }

        }
        return themeInfoList;
    }

}
