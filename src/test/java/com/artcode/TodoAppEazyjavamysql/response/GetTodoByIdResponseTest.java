package com.artcode.TodoAppEazyjavamysql.response;

import com.artcode.TodoAppEazyjavamysql.entity.Todo;
import org.junit.jupiter.api.Test;

public class GetTodoByIdResponseTest {

    @Test
    public void response(){
        Todo todo = new Todo();
        todo.setTopic("test");
        todo.setMessage("test2");

        TodoResponse response = new TodoResponse(todo);

        System.out.println(response.toString());

    }
}
