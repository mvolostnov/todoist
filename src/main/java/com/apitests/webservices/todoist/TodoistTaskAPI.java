package com.apitests.webservices.todoist;

import com.apitests.test.data.entities.newtaskdata.TaskData;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

@AllArgsConstructor
public class TodoistTaskAPI {

    private final String token;

    public Response createTask(TaskData taskData) {

        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);

        return  given().
                contentType(TodoistAPI.CONTENT_TYPE)
                .headers(headers)
                .log().headers()
                .body(taskData)
                .log().body()
                .when()
                .post(Endpoints.createNewTask);
   }
}


