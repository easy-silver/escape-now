package com.timo.escapenow.web.crawler;

import com.timo.escapenow.web.dto.ThemeInfo;
import org.junit.jupiter.api.Test;

import java.util.List;

class NextEditionTableParserTest {

    NextEditionParser parser = new NextEditionParser();

    private final String gangnamUrl = "https://www.nextedition.co.kr/shops/NextEdition%20Gangnam";
    private final String gangnam2Url = "https://www.nextedition.co.kr/shops/NextEdition%20Gangnam2";
    private final String gangnam3Url = "https://www.nextedition.co.kr/shops/NextEdition%20Gangnam3";
    private final String gangnamsinnonhyunUrl = "https://www.nextedition.co.kr/shops/Nextedition%20gangnamsinnonhyun";
    private final String gangnam5Url = "https://www.nextedition.co.kr/shops/NextEdition%20Gangnam5";

    @Test
    void 강남점() {
        //when
        List<ThemeInfo> themeInfoList = parser.getThemesWithAvailableTimetable(gangnamUrl);
        //then
        printResult(themeInfoList);
    }

    @Test
    void 강남2호점() {
        //when
        List<ThemeInfo> themeInfoList = parser.getThemesWithAvailableTimetable(gangnam2Url);
        //then
        printResult(themeInfoList);
    }
    
    @Test
    void 강남3호점() {
        //when
        List<ThemeInfo> themeInfoList = parser.getThemesWithAvailableTimetable(gangnam3Url);
        //then
        printResult(themeInfoList);
    }

    @Test
    void 강남신논현점() {
        //when
        List<ThemeInfo> themeInfoList = parser.getThemesWithAvailableTimetable(gangnamsinnonhyunUrl);
        //then
        printResult(themeInfoList);
    }

    @Test
    void 강남5호점() {
        //when
        List<ThemeInfo> themeInfoList = parser.getThemesWithAvailableTimetable(gangnam5Url);
        //then
        printResult(themeInfoList);
    }

    private void printResult(List<ThemeInfo> themeInfoList) {
        System.out.println("예약 가능한 테마 수: " + themeInfoList.size());

        for (ThemeInfo themeInfo : themeInfoList) {
            System.out.println(themeInfo);
        }
    }

}