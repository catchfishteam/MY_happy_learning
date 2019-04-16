package com.shenzk.web.service.impl;

import com.shenzk.web.dao.QuestionDao;
import com.shenzk.web.domain.Question;
import com.shenzk.web.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("questionServiceImpl")
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;

    @Override
    public int update(String question, Integer success) {
        System.out.println("question update");
        return questionDao.update(question, success);
    }

    @Override
    public List<Question> getQuestionRateList() {
        List<Question> list = questionDao.getQuestionRateList();
        for(Question q: list){
            double d = q.getSuccessNum()/(q.getSubmitNum()*1.0);
            q.setSuccessRate((double) Math.round(d * 100) / 100);
        }
        return list;
    }
}
