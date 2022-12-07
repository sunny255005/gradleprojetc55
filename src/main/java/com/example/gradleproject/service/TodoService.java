package com.example.gradleproject.service;

import com.example.gradleproject.model.Todo;

public interface TodoService  {
    

    //add todo

    Todo addtodo(Todo t1);

    //get todo by id;

    Todo getTododById(int todoId);

    
    //update id
    Todo updateTodo(Todo t1,int todoId);

    void deleteTodo(int todoId);


}
