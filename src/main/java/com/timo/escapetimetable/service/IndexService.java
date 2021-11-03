package com.timo.escapetimetable.service;

import com.timo.escapetimetable.domain.AreaCode;
import com.timo.escapetimetable.domain.branch.Branch;
import com.timo.escapetimetable.domain.branch.BranchRepository;
import com.timo.escapetimetable.domain.shop.Shop;
import com.timo.escapetimetable.domain.shop.ShopRepository;
import com.timo.escapetimetable.dto.ThemeResponse;
import com.timo.escapetimetable.parser.NextEditionParser;
import com.timo.escapetimetable.parser.Parser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class IndexService {

    private final ShopRepository shopRepository;
    private final BranchRepository branchRepository;

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

    /**
     * 매장별 지점 목록 조회
     *
     * @param area
     * @param shopId
     * @return
     */
    public List<Branch> getBranchListInShop(String area, Long shopId) {
        AreaCode areaCode = AreaCode.valueOf(area);

        Shop shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 매장 번호=" + shopId));

        return branchRepository.findAllByShopAndAreaCode(shop, areaCode);
    }

    /**
     * 해당 매장의 예약 가능한 테마 정보 조회
     *
     * @param branchId
     * @return
     */
    public ThemeResponse getThemesAndTimetable(Long branchId) {
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 지점 번호 = " + branchId));

        ThemeResponse response = new ThemeResponse();

        String shopName = branch.getShop().getName();
        Parser parser = null;

        switch (shopName) {
            case "넥스트에디션":
                parser = new NextEditionParser();
                break;
        }

        response.setShop(shopName);
        response.setBranch(branch.getName());
        response.setThemes(parser.getThemesWithAvailableTimetable(branch.getUrl()));

        return response;
    }
}
