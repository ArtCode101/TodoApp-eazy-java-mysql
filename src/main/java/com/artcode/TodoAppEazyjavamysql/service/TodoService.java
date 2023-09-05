package com.artcode.TodoAppEazyjavamysql.service;

import com.artcode.TodoAppEazyjavamysql.entity.Todo;
import com.artcode.TodoAppEazyjavamysql.repository.TodoJpaRepository;
import com.artcode.TodoAppEazyjavamysql.request.CreateTodoRequest;
import com.artcode.TodoAppEazyjavamysql.response.TodoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public TodoResponse getById(int id)throws Exception{
        try {

             Todo todo = repository.getById(id);
             return new TodoResponse(todo);
        }catch (Exception ex){
            throw  new Exception(ex);
        }
    }

    public List<TodoResponse> get()throws Exception{
        try {
            List<Todo> todos = repository.findAll();

            List<TodoResponse> responses = new ArrayList<>();
            for (Todo todo : todos){
                responses.add(new TodoResponse(todo));
            }
            return responses;
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    public TodoResponse updateStatus(Integer id ,Boolean status)throws Exception{
        try {
            Todo todo = repository.findById(id).get();
            todo.setStatus(status);
            todo = repository.save(todo);
            return new TodoResponse(todo);
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    public void delete(Integer id) throws Exception {
        try {
            repository.deleteById(id);
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }
}
