package com.timo.escapetimetable.service;

import com.timo.escapetimetable.domain.AreaCode;
import com.timo.escapetimetable.domain.shop.Shop;
import com.timo.escapetimetable.domain.shop.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class IndexService {

    private final ShopRepository shopRepository;

    /**
     * 지역별 매장 목록 조회
     *
     * @param area
     * @return
     */
    public List<Shop> getShopListInArea(String area) {
        AreaCode areaCode = AreaCode.valueOf(area);

        return shopRepository.findAllByAreaCode(areaCode);
    }

}
