package com.timo.escapenow.service.crawler;

import com.timo.escapenow.web.dto.ThemeInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class MasterKeyThemeFinderTest {

    ThemeFinder finder = new MasterKeyThemeFinder();

    @DisplayName("강남프라임점 예약 가능 테마 확인")
    @Test
    void gangnamPrime() {
        //given
        String url = "http://www.master-key.co.kr/booking/bk_detail?bid=29";

        //when
        List<ThemeInfo> availableThemes = finder.findAvailableThemes(url);

        //then
        printResult(availableThemes);
    }

    private void printResult(List<ThemeInfo> themeInfoList) {
        System.out.println("예약 가능한 테마 수: " + themeInfoList.size());

        for (ThemeInfo themeInfo : themeInfoList) {
            System.out.println(themeInfo);
        }
    }
}