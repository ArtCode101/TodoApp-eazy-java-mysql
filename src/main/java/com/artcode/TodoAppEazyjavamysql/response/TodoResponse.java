package com.artcode.TodoAppEazyjavamysql.response;

import com.artcode.TodoAppEazyjavamysql.entity.Todo;
import lombok.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Data
public class TodoResponse {

    private Integer id;

    private String topic;

    private String message;

    private Boolean status;

    private String timestamp;

    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.topic = todo.getTopic();
        this.message = todo.getMessage();
        this.status = todo.getStatus();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd'T'hh:mm:ss.SSSZ");
        String strDate = dateFormat.format(todo.getTimestamp());
        this.timestamp = strDate;
    }
}
