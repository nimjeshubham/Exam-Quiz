package com.school.pack.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.pack.Model.Question;
import com.school.pack.Model.Test;
import com.school.pack.Repository.TestRepo;

@Service
public class TestDao implements QuestionClient {
	
	@Autowired
	private TestRepo repo;
	
	@Autowired
	private QuestionClient client;
	
    public TestDao(TestRepo repo, QuestionClient client) {
		super();
		this.repo = repo;
		this.client = client;
	}
	
	public Test insert(Test t) {
		return repo.save(t);
	}
	
	public List<Test> insertAll(List<Test> test){
		return repo.saveAll(test);
	}
	
	public List< Test> getAll(){
		List<Test> testList =repo.findAll();
		for (Test t: testList) {
			t.setQuestion(client.getQuestionOfTest(t.getTestId()));
		}
		return testList;
	}
	
	

	public Test get(Integer id) {
		Test test =repo.findById(id).orElse(null);
		test.setQuestion(client.getQuestionOfTest(id));
		return test;
	}
	
	public Test update(Test t) {
		Test tt = repo.findById(t.getTestId()).orElse(null);
		tt.setDate(t.getDate());
		tt.setSubject(t.getSubject());
		return repo.save(tt);
	}
	
	public String delete(Integer id) {
		repo.deleteById(id);
		return "deleted the id value "+id;
	}

	@Override
	public List<Question> getQuestionOfTest(int id) {
		List<Question> questionList = client.getQuestionOfTest(id);
		return questionList;
	}

}
