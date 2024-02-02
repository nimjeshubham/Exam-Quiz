package com.school.pack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExamQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamQuizApplication.class, args);
	}

}
