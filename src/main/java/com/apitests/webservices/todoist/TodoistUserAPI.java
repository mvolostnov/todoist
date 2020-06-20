package com.apitests.webservices.todoist;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

@Slf4j
@AllArgsConstructor
public class TodoistUserAPI {

    private final String token;

    public void deleteUser(String pswd){

        given().
                contentType(JSON)
                .queryParam("token", token)
                .queryParam("current_password", pswd)
                .log().body()
                .when()
                .post(Endpoints.deleteUser)
                .then()
                .statusCode(200);
        log.info("Deleted user with token = {}", token);
    }
}
