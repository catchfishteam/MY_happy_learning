package com.shenzk.web.dao;

import com.shenzk.web.domain.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionDao {

    int update(String question, Integer success);

    List<Question> getQuestionRateList();

}
