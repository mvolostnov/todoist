package com.apitests.test.data.entities.newtaskdata;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class Due {
    String date;
    String datetime;
    String string;
    String timezone;
}
