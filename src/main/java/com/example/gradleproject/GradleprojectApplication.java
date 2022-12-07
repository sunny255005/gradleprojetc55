package com.example.gradleproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.example.gradleproject.model.Todo;
import com.example.gradleproject.service.TodoService;

// @EnableCaching
@SpringBootApplication
public class GradleprojectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GradleprojectApplication.class, args);
	}


	@Autowired
	TodoService todoService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Todo t1=new Todo("Watch Movie",java.time.LocalDateTime.now());
		todoService.addtodo(t1);

		

		


		
	}

}
