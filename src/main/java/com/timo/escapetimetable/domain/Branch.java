package com.timo.escapetimetable.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Branch {

    @Id @GeneratedValue
    @Column(name = "branch_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @Column(name = "name", nullable = false)
    private String name;

    //지역 코드
    @Enumerated(value = EnumType.STRING)
    @Column(name = "area_code", nullable = false)
    private AreaCode areaCode;

    //예약 URL
    @Column(name = "url", nullable = false)
    private String url;

}
