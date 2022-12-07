package com.example.gradleproject.controller;

import com.example.gradleproject.model.Todo;
import com.example.gradleproject.service.TodoService;
import com.example.gradleproject.service.TodoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TodoControllerTest {


    @Mock
    TodoServiceImpl todoServiceImpl;

    @InjectMocks
    TodoController todoController;

    @Test
    public void get_todo_by_id_test(){
        Todo todo=new Todo("cricket",new Date().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime());
        when(todoServiceImpl.getTododById(1))
                .thenReturn(todo);

        ResponseEntity<?> response = todoController.getTODOByIdController(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }



}
