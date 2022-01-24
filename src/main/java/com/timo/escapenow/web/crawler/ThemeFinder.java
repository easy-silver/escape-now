package com.timo.escapenow.web.crawler;

import com.timo.escapenow.web.dto.ThemeInfo;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

/**
 * 테마 정보 크롤링을 위한 추상 클래스
 * (공통 처리 로직 구현, 매장별 크롤링 로직 위임)
 */
@Slf4j
public abstract class ThemeFinder {

    /**
     * 예약 가능한 테마 정보 조회
     * @param reservationUrl
     * @return List
     */
    public List<ThemeInfo> findAvailableThemes(String reservationUrl) {
        Connection connection = initConnect(reservationUrl);
        Document document = getDocument(connection);

        return crawlingThemes(document);
    }

    /** 크롤링을 위한 ㄹURL 연결 */
    private Connection initConnect(String url) {
        Connection connection = Jsoup.connect(url);
        log.info("URL:{} 연결 성공", url);

        return connection;
    }

    /** 연결된 페이지의 HTML 문서 획득 */
    private Document getDocument(Connection connection) {
        Document document = null;

        try {
            document = connection.get();
            log.info("페이지의 HTML 문서 획득");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return document;
    }

    /**
     * 테마 정보 크롤링
     * (페이지에 맞게 재정의하여 크롤링 구현)
     *
     * @param document
     * @return List
     */
    abstract protected List<ThemeInfo> crawlingThemes(Document document);
}