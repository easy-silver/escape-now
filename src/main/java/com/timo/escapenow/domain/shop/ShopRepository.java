package com.timo.escapenow.domain.shop;

import com.timo.escapenow.domain.AreaCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    /**
     * 지역 코드별 매장 목록 조회
     *
     * @param areaCode
     * @return List<Shop>
     */
    @Query("SELECT s " +
            "FROM Shop s " +
            "JOIN Branch b " +
            "ON s.id = b.shop.id " +
            "WHERE b.areaCode = :areaCode " +
            "GROUP BY s.id")
    List<Shop> findAllByAreaCode(@Param("areaCode") AreaCode areaCode);
}
