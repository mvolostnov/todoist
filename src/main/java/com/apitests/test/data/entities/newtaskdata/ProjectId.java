package com.apitests.test.data.entities.newtaskdata;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ProjectId {
    PROJECT_NAME(223858542);

    @Getter
    private final long projectId;
}
