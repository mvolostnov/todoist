package com.apitests.test.data.entities.newtaskdata;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Content {
    CONTENT("Some content");

    @Getter
    private final String content;

}
