package com.example.gradleproject.model;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Todo")
public class Todo {

    // private String userName;

    // private Integer userId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer todoId;

    private String todoName;

    private LocalDateTime createdAt;

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Todo() {
    }

    public Todo(String todoName, LocalDateTime localDateTime) {
        this.todoName = todoName;
        this.createdAt = localDateTime;
    }

}
