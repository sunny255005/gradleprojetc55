package com.example.gradleproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gradleproject.model.Todo;
import com.example.gradleproject.service.TodoService;


@RequestMapping("/todo-app/v1")
@RestController
public class TodoController {
    
    @Autowired
    TodoService todoService;

    @PostMapping("/add-todo")
    public ResponseEntity<Todo> addTODOController(@RequestBody Todo todo){
        Todo newtodo=todoService.addtodo(todo);
        HttpHeaders header=new HttpHeaders();
        header.add("description","added a new todo");
        return ResponseEntity.ok().headers(header).body(newtodo);


 }

//  @CachePut(value="todo",key="#todoId")
    @PutMapping("/edit-todo/{todoId}")
    public ResponseEntity<Todo>updateTODOController(@RequestBody Todo todo,@PathVariable int todoId)
    {
        Todo t1=todoService.updateTodo(todo, todoId);
        HttpHeaders h=new HttpHeaders();
        h.add("desc","updated of todo"+todoId);

        return ResponseEntity.ok().headers(h).body(t1); 
    }

    // @Cacheable(value="todo",key="#todoId")
    @GetMapping("/getTodo/by/{todoId}")
    public ResponseEntity<Todo>getTODOByIdController(@PathVariable int todoId)
 {
     Todo todo=todoService.getTododById(todoId);
     HttpHeaders header=new HttpHeaders();
     header.add("desc","one todo is found by id "+todoId);
    return ResponseEntity.ok().headers(header).body(todo);
    

 }

//  @CacheEvict(value="todo",key="#todoId")
 public ResponseEntity<Void>deleteTODOByIdController(@PathVariable int todoId)
 {
     todoService.deleteTodo(todoId);
     HttpHeaders h=new HttpHeaders();
     h.add("desc","id "+todoId+" is deeleted");
     return ResponseEntity.ok().headers(h).build();
 }



}
