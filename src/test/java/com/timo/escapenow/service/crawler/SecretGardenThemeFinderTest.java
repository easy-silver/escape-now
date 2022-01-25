package com.timo.escapenow.service.crawler;

import com.timo.escapenow.web.dto.ThemeInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class SecretGardenThemeFinderTest {

    @DisplayName("리버타운 강남점")
    @Test
    void rivertownGangnam() {
        //given
        String url = "http://www.secretgardenescape.com/reservation.html?k_shopno=9";

        //when
        ThemeFinder finder = new SecretGardenThemeFinder();
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