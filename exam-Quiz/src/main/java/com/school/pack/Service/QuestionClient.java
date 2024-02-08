package com.school.pack.Service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.school.pack.Model.Question;

//@FeignClient(url = "http://localhost:9090" , value = "questionClient")
@FeignClient(name ="QUESTION-SERVICE")
public interface QuestionClient {
	
	
	@GetMapping("/getByTestId/{id}")
	public List<Question> getQuestionOfTest(@PathVariable int id);

}
