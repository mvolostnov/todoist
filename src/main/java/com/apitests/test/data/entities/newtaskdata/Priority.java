package com.apitests.test.data.entities.newtaskdata;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Priority {
    NORMAL(1);

    @Getter
    private final Integer priority;
}
