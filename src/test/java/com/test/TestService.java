package com.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Application;
import com.shenzk.web.domain.Question;
import com.shenzk.web.service.QuestionService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})
public class TestService {

	@Autowired
	private QuestionService questionServiceImpl;
	
	@Test
	public void test1(){
		List<Question> list =  questionServiceImpl.getQuestionRateList();
		System.out.println(list);
	}
}
