package com.example.workflow;

import java.io.File;

import javax.annotation.PreDestroy;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication("myProcessApplicationName")
public class Application {


	public static void main(String... args) {
		SpringApplication.run(Application.class, args);
	}

	@PreDestroy
	public void preDestroy() {
		try {
			File file = new File("camunda-h2-database.mv.db");
			file.delete();
			file = new File("camunda-h2-database.trace.db");
			file.delete();
		}catch(Exception ex) {
			System.out.println("DB Files couldn't deleted!");
		}
	}

}