package com.apitests.test.data.entities;

import com.apitests.test.data.entities.newtaskdata.TaskData;
import org.testng.annotations.DataProvider;


public class DataProviderClass {

    @DataProvider(name = "emptyTaskContent")
    public Object[][] emptyTaskContent(){
        return new Object[][]{
                new Object[]{
                        TaskData.builder()
                                .content(null)
                                .build()},

                new Object[]{
                        TaskData.builder()
                                .content(" ")
                                .build()}
        };
    }

}
