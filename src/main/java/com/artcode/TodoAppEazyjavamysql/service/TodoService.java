package com.artcode.TodoAppEazyjavamysql.service;

import com.artcode.TodoAppEazyjavamysql.entity.Todo;
import com.artcode.TodoAppEazyjavamysql.repository.TodoJpaRepository;
import com.artcode.TodoAppEazyjavamysql.request.CreateTodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoJpaRepository repository;

    public Todo create(CreateTodoRequest request) throws Exception{
        Todo todo = new Todo();
        todo.setTopic(request.getTopic());
        todo.setMessage(request.getMessage());

        try {
            return repository.save(todo);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            throw new Exception(ex);
        }

    }
}
