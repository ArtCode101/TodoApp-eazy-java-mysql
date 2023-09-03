package com.artcode.TodoAppEazyjavamysql.repository;

import com.artcode.TodoAppEazyjavamysql.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TodoJpaRepositoryTest {

    @Autowired
    private TodoJpaRepository repository;

    @Test
    public void save(){
        Todo todo = new Todo();
        todo.setTopic("test");
        todo.setMessage("description");

        System.out.println(todo.getTimestamp());
        try {
            todo = repository.save(todo);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(todo.toString());

    }
}
