package com.gxu.tour.entity;

/**
 * Create by LLM
 * Function: 存放统计表的分析结果
 */
public class Rank {

    //主键
    private Integer ID;
    //名称
    private String name;
    //次数
    private Integer num;

    public Rank(Integer ID, String name, Integer num) {
        this.ID = ID;
        this.name = name;
        this.num = num;
    }

    public Rank()
    {

    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
