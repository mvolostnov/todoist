package com.apitests.webservices.todoist;

import com.apitests.test.data.entities.UserData;
import com.mx.testframework.utils.RandomString;
import lombok.extern.slf4j.Slf4j;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

@Slf4j
public class TodoistAPI {

    public static final String CONTENT_TYPE = "application/json";
    private static String token;

    public TodoistAPI registerNewUser() {
        Map<String, Object> userData = new HashMap<>();
        userData.put("email", RandomString.randomString(6) + "@example.com");
        userData.put("full_name", UserData.fullName);
        userData.put("password", UserData.password);

        token =
                given().
                        contentType(JSON)
                        .queryParams(userData)
                        .log().parameters()
                        .log().body()
                        .when()
                        .post(Endpoints.registerNewUser)
                        .then()
                        .statusCode(200)
                        .extract().response().body().path("token");
        log.info("Register new user with token = {}", token);
        return this;
    }

    public TodoistTaskAPI taskAPI(){
        return new TodoistTaskAPI(token);
    }

    public TodoistUserAPI userAPI(){
        return new TodoistUserAPI(token);
    }

}
