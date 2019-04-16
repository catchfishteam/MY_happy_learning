package com.shenzk.web.domain;

public class Question {

    private Integer id;
    private String question;
    private Integer successNum;
    private Integer submitNum;
    private Double successRate;

    public Question() {
    }

    public Question(String question, Integer successNum, Integer submitNum) {
        this.question = question;
        this.successNum = successNum;
        this.submitNum = submitNum;
    }

    public Question(String question, Integer successNum, Integer submitNum, Double successRate) {
        this.question = question;
        this.successNum = successNum;
        this.submitNum = submitNum;
        this.successRate = successRate;
    }

    public Double getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(Double successRate) {
        this.successRate = successRate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(Integer successNum) {
        this.successNum = successNum;
    }

    public Integer getSubmitNum() {
        return submitNum;
    }

    public void setSubmitNum(Integer submitNum) {
        this.submitNum = submitNum;
    }
}
