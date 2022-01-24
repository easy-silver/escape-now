package com.timo.escapenow.service.crawler;

import com.timo.escapenow.web.dto.ThemeInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class NextEditionThemeFinderTest {

    ThemeFinder finder = new NextEditionThemeFinder();

    @DisplayName("강남1호점 예약 가능 테마 확인")
    @Test
    void gangnam1() {
        //given
        String url = "https://www.nextedition.co.kr/shops/NextEdition%20Gangnam";
        //when
        List<ThemeInfo> themeInfoList = finder.findAvailableThemes(url);
        //then
        printResult(themeInfoList);
    }

    @DisplayName("강남2호점 예약 가능 테마 확인")
    @Test
    void gangnam2() {
        //given
        String url = "https://www.nextedition.co.kr/shops/NextEdition%20Gangnam2";
        //when
        List<ThemeInfo> themeInfoList = finder.findAvailableThemes(url);
        //then
        printResult(themeInfoList);
    }

    @DisplayName("강남3호점 예약 가능 테마 확인")
    @Test
    void gangnam3() {
        //given
        String url = "https://www.nextedition.co.kr/shops/NextEdition%20Gangnam3";
        //when
        List<ThemeInfo> themeInfoList = finder.findAvailableThemes(url);
        //then
        printResult(themeInfoList);
    }

    @DisplayName("강남신논현점 예약 가능 테마 확인")
    @Test
    void gangnamSinnonhyun() {
        //given
        String url = "https://www.nextedition.co.kr/shops/Nextedition%20gangnamsinnonhyun";
        //when
        List<ThemeInfo> themeInfoList = finder.findAvailableThemes(url);
        //then
        printResult(themeInfoList);
    }

    @DisplayName("강남5호점 예약 가능 테마 확인")
    @Test
    void gangnam5() {
        //given
        String url = "https://www.nextedition.co.kr/shops/NextEdition%20Gangnam5";
        //when
        List<ThemeInfo> themeInfoList = finder.findAvailableThemes(url);
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