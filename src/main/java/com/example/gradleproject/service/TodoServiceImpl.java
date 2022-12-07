package com.example.gradleproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gradleproject.model.Todo;
import com.example.gradleproject.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {



    @Autowired
    TodoRepository todoRepository;


    @Override
    public Todo addtodo(Todo t1) {
        // TODO Auto-generated method stub
        return todoRepository.save(t1);
    }

    @Override
    public Todo getTododById(int todoId) {
        // TODO Auto-generated method stub
        return todoRepository.findById(todoId).get();
    }

    @Override
    public void deleteTodo(int todoId) {
        // TODO Auto-generated method stub
        todoRepository.deleteById(todoId);
    }

    @Override
    public Todo updateTodo(Todo t1,int todoId) {
        // TODO Auto-generated method stub
        Todo t2=todoRepository.getById(todoId);
        t2.setTodoName(t1.getTodoName());
        return t2;
    }

    



}
