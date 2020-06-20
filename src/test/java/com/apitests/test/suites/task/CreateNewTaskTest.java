package com.apitests.test.suites.task;

import com.apitests.test.BaseTest;
import com.apitests.test.data.entities.DataProviderClass;
import com.apitests.test.data.entities.newtaskdata.Content;
import com.apitests.test.data.entities.newtaskdata.TaskData;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@Slf4j
public class CreateNewTaskTest extends BaseTest {

    @Test()
    public void addNewTaskMandatoryFieldsTest()  {

        log.info("Start addNewTaskMandatoryFieldsTest: ");
        TaskData taskData = TaskData.buildTaskDataMandatoryFields(Content.CONTENT.getContent());
        extentTest.info("Start test with the following data: " + taskData.toString());

        ws.todoistAPI()
                .registerNewUser()
                .taskAPI()
                .createTask(taskData)
                .then()
                .log().body()
                .statusCode(200)
                .body("content", equalTo(taskData.content))
                .body("url", response -> equalTo("https://todoist.com/showTask?id=" + response.path("id")))
        ;

       ws.todoistAPI()
                .userAPI()
                .deleteUser("Example1234");

    }


    @Test(dataProvider = "emptyTaskContent", dataProviderClass = DataProviderClass.class)
    public void addNewTaskEmptyMandatoryFieldsTest(TaskData td)  {

        log.info("Start addNewTaskEmptyMandatoryFieldsTest: ");
        TaskData taskData = TaskData.buildTaskDataMandatoryFields(td.getContent());
        extentTest.info("Start test with the following data: " + taskData.toString());

        ws.todoistAPI()
                .registerNewUser()
                .taskAPI()
                .createTask(taskData)
                .then()
                .log().body()
                .statusCode(400)
        ;

        ws.todoistAPI()
                .userAPI()
                .deleteUser("Example1234");

    }

    @Test()
    public void addNewTaskAllFieldsTest()  {

        log.info("Start addNewTaskAllFieldsTest: ");
        TaskData taskData = TaskData.buildTaskDataAllFields();
        extentTest.info("Start test with the following data: " + taskData.toString());

        ws.todoistAPI()
                .registerNewUser()
                .taskAPI()
                .createTask(taskData)
                .then()
                .log().body()
                .statusCode(200)
                .body("content", equalTo(taskData.content))
                .body("url", response -> equalTo("https://todoist.com/showTask?id=" + response.path("id")))
//               .body("comment_count", equalTo(taskData.commentCount))
                .body("completed", equalTo(taskData.completed))
                .body("id", notNullValue())
//                .body("id", equalTo(taskData.id))
                .body("priority", equalTo(taskData.priority))
//                .body("project_id", equalTo(taskData.projectId))
//                .body("section_id", equalTo(taskData.sectionId))
        ;

        ws.todoistAPI()
                .userAPI()
                .deleteUser("Example1234");
    }

}
