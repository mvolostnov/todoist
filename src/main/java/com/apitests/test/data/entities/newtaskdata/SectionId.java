package com.apitests.test.data.entities.newtaskdata;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SectionId {
    SECTION_NAME(123);

    @Getter
    private final long sectionId;
}
