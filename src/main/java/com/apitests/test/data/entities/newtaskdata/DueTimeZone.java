package com.apitests.test.data.entities.newtaskdata;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum DueTimeZone {
    EUROPE_LISBON("Europe/Lisbon");

    @Getter
    private final String timeZone;
}
