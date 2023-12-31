package com.artcode.TodoAppEazyjavamysql.controller;

import com.artcode.TodoAppEazyjavamysql.request.CreateTodoRequest;
import com.artcode.TodoAppEazyjavamysql.request.UpdateTodoRequest;
import com.artcode.TodoAppEazyjavamysql.response.TodoResponse;
import com.artcode.TodoAppEazyjavamysql.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService service;


    @PostMapping("/todo/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create( @RequestBody @Validated CreateTodoRequest request) throws Exception {
        service.create(request);
        return;
    }

    @GetMapping("/todo/{id}")
    public TodoResponse getById(
            @PathVariable("id") Integer id
    )throws Exception{
        return service.getById(id);
    }

    @GetMapping("/todo")
    public List<TodoResponse> get()throws Exception{
        return  service.get();
    }

    @PutMapping("/todo/{id}")
    public TodoResponse update(
            @PathVariable("id") Integer id,
            @RequestBody UpdateTodoRequest request
            )throws Exception{
        return service.updateStatus(id,request.getStatus());
    }

    @DeleteMapping("/todo/{id}")
    public void delete(
            @PathVariable("id") Integer id
    )throws Exception{
        service.delete(id);
        return;
    }
}
