package com.school.pack.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.pack.Model.Test;
import com.school.pack.Repository.TestRepo;

@Service
public class TestDao {
	
	@Autowired
	TestRepo repo;
	
	public Test insert(Test t) {
		return repo.save(t);
	}
	
	public List< Test> getAll(){
		return repo.findAll();
	}
	
	public Test get(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	public Test update(Test t) {
		Test tt = repo.findById(t.getTestId()).orElse(null);
		tt.setDate(t.getDate());
		tt.setSubject(t.getSubject());
		return repo.save(tt);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}

}
