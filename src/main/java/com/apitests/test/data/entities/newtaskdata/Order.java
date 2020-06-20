package com.apitests.test.data.entities.newtaskdata;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Order {
    ORDER_1(1);

    @Getter
    private final Integer order;
}
