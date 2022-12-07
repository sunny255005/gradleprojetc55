package com.example.gradleproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gradleproject.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {
    
}
