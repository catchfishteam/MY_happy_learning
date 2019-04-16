package com.shenzk.web.controller;


import com.shenzk.web.domain.Question;
import com.shenzk.web.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping("/updateQuestion")
    public int updateQuestion(HttpServletRequest request, HttpServletResponse response){
        System.out.println("updateQuestion executor");
        String question = request.getParameter("question");
        String success = request.getParameter("success");
        return questionService.update(question, Integer.parseInt(success));
    }

    @RequestMapping("/questionSuccessRateList")
    public List<Question> questionSuccessRateList(){
        return questionService.getQuestionRateList();
    }
}
