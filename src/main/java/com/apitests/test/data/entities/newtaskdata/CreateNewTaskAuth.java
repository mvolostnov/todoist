package com.apitests.test.data.entities.newtaskdata;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class CreateNewTaskAuth {
    protected String token;
}
