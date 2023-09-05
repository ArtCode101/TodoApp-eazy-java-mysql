package com.artcode.TodoAppEazyjavamysql.request;


import lombok.Data;

@Data
public class CreateTodoRequest {

    private String topic;

    private String message = "";
}
