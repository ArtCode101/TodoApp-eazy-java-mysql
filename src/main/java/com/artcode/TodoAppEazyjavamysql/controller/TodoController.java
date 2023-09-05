package com.artcode.TodoAppEazyjavamysql.controller;

import com.artcode.TodoAppEazyjavamysql.request.CreateTodoRequest;
import com.artcode.TodoAppEazyjavamysql.response.GetTodoByIdResponse;
import com.artcode.TodoAppEazyjavamysql.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/todo/get/{id}")
    public GetTodoByIdResponse getById(
            @PathVariable("id") Integer id
    )throws Exception{
        return service.getById(id);
    }
}
