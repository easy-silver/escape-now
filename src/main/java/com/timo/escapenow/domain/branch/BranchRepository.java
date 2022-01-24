package com.timo.escapenow.domain.branch;

import com.timo.escapenow.domain.AreaCode;
import com.timo.escapenow.domain.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Long> {

    /**
     * 매장의 전체 지점 조회
     *
     * @param shop
     * @return
     */
    List<Branch> findAllByShop(Shop shop);

    /**
     * 매장의 해당 지역 전체 지점 조회
     *
     * @param shop
     * @param areaCode
     * @return
     */
    List<Branch> findAllByShopAndAreaCode(Shop shop, AreaCode areaCode);

}
