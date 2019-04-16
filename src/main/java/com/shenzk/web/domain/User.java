package com.shenzk.web.domain;


public class User {

    private Integer id;
    private Integer rank;
    private String name;
    private Integer finishNum;
    private String lastTime;

    public User() {
    }

    public User(String name, Integer finishNum, String lastTime) {
        this.name = name;
        this.finishNum = finishNum;
        this.lastTime = lastTime;
    }

    public User(Integer id, Integer rank, String name, Integer finishNum, String lastTime) {
        this.id = id;
        this.rank = rank;
        this.name = name;
        this.finishNum = finishNum;
        this.lastTime = lastTime;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFinishNum() {
        return finishNum;
    }

    public void setFinishNum(Integer finishNum) {
        this.finishNum = finishNum;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }
}
