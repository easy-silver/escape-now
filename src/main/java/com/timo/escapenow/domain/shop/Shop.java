package com.timo.escapenow.domain.shop;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

}
