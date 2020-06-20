package com.apitests.webservices;

import com.apitests.webservices.todoist.TodoistAPI;

public class WebService {
    public TodoistAPI todoistAPI(){
        return new TodoistAPI();
    }
}
