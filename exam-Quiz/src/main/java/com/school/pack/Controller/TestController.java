package com.school.pack.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.school.pack.Model.Test;
import com.school.pack.Service.TestDao;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class TestController {
	
	@Autowired
	TestDao dao;
	
	@RequestMapping("/adminLogin")
	public ModelAndView adminLogin(HttpServletRequest req, HttpServletResponse res) {
    ModelAndView mv = new ModelAndView();
    String admin= req.getParameter("adminID");
    String password= req.getParameter("pass");
	try {
		if(admin.contentEquals("admin") && password.contentEquals("123456")) {
			mv.setViewName("operations");
		}
		else {
			mv.setViewName("somethingWrongEnter1");
		}
		
		}catch (Exception e) {
			mv.setViewName("somethingWrongEnter1");
		}
		return mv;
	}
	
	@RequestMapping("/registerTest")
	public ModelAndView registerTest(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		try {
			Test test = new Test();
			test.setSubject(req.getParameter("subject"));
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
			Date date = s.parse(req.getParameter("date"));
		    test.setDate(date);
		    dao.insert(test);
		    mv.setViewName("showTest");
		    mv.addObject("test", test);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
		
		
		
		
	}
	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		try {
			if (dao.get(Integer.parseInt( req.getParameter("testId"))) != null) {
				Test test = dao.get(Integer.parseInt( req.getParameter("testId")));
				test.setSubject(req.getParameter("subject"));
				SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
				Date date = s.parse(req.getParameter("date"));
			    test.setDate(date);
			    dao.update(test);
			    mv.setViewName("showTest");
			    mv.addObject("test", test);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		dao.delete(Integer.parseInt( req.getParameter("testId")));
		mv.setViewName("operations");
		return mv;
		}
	
	@RequestMapping("/getIndi")
	public ModelAndView getIndi(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		try {
			if (dao.get(Integer.parseInt( req.getParameter("testId"))) != null) {
				Test test = dao.get(Integer.parseInt( req.getParameter("testId")));
			    mv.setViewName("showTest");
			    mv.addObject("test", test);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return mv;
	 }
	@RequestMapping("/getAll")
	public ModelAndView getAll(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		List<Test> list = dao.getAll();
		mv.setViewName("getAll");
		mv.addObject("list", list);
		return mv;
	}

}
