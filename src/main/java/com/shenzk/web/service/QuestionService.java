package com.shenzk.web.service;

import com.shenzk.web.domain.Question;

import java.util.List;

public interface QuestionService {

    int update(String question, Integer success);

    List<Question> getQuestionRateList();

}
