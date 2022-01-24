package com.timo.escapenow.domain.branch;

import com.timo.escapenow.domain.AreaCode;
import com.timo.escapenow.domain.shop.Shop;
import com.timo.escapenow.domain.shop.ShopRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BranchRepositoryTest {

    @Autowired BranchRepository repository;
    @Autowired ShopRepository shopRepository;

    @Test
    void 매장의_전체_지점_조회() {
        //given
        Long shopId = 1L;
        Shop nextEdition = shopRepository.findById(shopId).get();

        //when
        List<Branch> result = repository.findAllByShop(nextEdition);

        //then
        assertThat(result.size()).isEqualTo(5);
    }
    
    @Test
    void 매장의_특정_지역_전체_지점_조회() {
        //given
        Long shopId = 1L;
        Shop nextEdition = shopRepository.findById(shopId).get();
        AreaCode areaCode = AreaCode.GN;

        //when
        List<Branch> result = repository.findAllByShopAndAreaCode(nextEdition, areaCode);

        //then
        assertThat(result.size()).isEqualTo(5);
    }
}