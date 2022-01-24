package com.timo.escapenow.domain.shop;

import com.timo.escapenow.domain.AreaCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ShopRepositoryTest {

    @Autowired ShopRepository repository;

    @Test
    void 전체_매장_조회() {
        //when
        List<Shop> result = repository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void 단일_매장_조회() {
        //given
        Long shopId = 1L;

        //when
        Shop findShop = repository.findById(shopId).get();

        //then
        assertThat(findShop.getName()).isEqualTo("넥스트에디션");
    }
    
    @Test
    void 지역코드별_매장_조회() {
        //given
        //AreaCode areaCode = AreaCode.GN;
        AreaCode areaCode = AreaCode.HD;

        //when
        List<Shop> result = repository.findAllByAreaCode(areaCode);

        //then
        assertThat(result.size()).isEqualTo(1);
    }

}