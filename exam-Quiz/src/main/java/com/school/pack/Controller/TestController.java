package com.school.pack.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.school.pack.Model.Test;
import com.school.pack.Service.TestDao;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class TestController {
	
	@Autowired
	TestDao dao;
	
	@PostMapping("/insert")
	public Test insert(@RequestBody Test test) {
		return dao.insert(test);
	}
	
	@PostMapping("/insertAll")
	public List<Test> insertAll(@RequestBody List<Test> test){
		return dao.insertAll(test);
	}
	
	@GetMapping("/get/{id}")
	public Test getById(@PathVariable int id) {
		return dao.get(id);
	}
	
	
	
	@GetMapping("/getAll")
	public List<Test> getAll(){
		return dao.getAll();
	}
	
	@PutMapping("/update")
	public Test update(@RequestBody Test test) {
		return dao.update(test);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return dao.delete(id);
	}
}
