package com.apitests.test.data.entities.newtaskdata;

import com.mx.testframework.utils.RandomNumericInt;
import com.mx.testframework.utils.RandomNumericLong;
import lombok.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
public class TaskData {
    public Integer commentCount;
    public boolean completed;
    public String content;
    public Due due;
    public Long id;
    public Integer order;
    public Integer priority;
    public Long projectId;
    public Long sectionId;
    public Long parentId;
    public String url;


    public static TaskData buildTaskDataMandatoryFields(String content){
        return TaskData.builder()
                .content(content)
                .build();
    }

    public static TaskData buildTaskDataAllFields(){

        final String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date()) + 1;

        return TaskData.builder()
                .commentCount(RandomNumericInt.randomNum(10))
                .completed(false)
                .content(Content.CONTENT.getContent())
                .due(Due.builder()
                        .date(date)
                        .datetime("2020-09-01T11:00:00Z")
                        .string("Tomorrow")
                        .timezone(DueTimeZone.EUROPE_LISBON.getTimeZone())
                        .build())
                .id(RandomNumericLong.randomNum(999999999))
                .order(Order.ORDER_1.getOrder())
                .priority(Priority.NORMAL.getPriority())
                .projectId(ProjectId.PROJECT_NAME.getProjectId())
                .sectionId(SectionId.SECTION_NAME.getSectionId())
                .parentId(ParentId.PARENT_NAME.getParentId())
                .url(Url.url)
                .build();
    }
}

