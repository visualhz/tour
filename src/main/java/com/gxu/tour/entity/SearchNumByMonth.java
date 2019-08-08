package com.gxu.tour.entity;

/**
 * Create By LLM 2019-08-07
 * Function:分析用户搜索日志,用户浏览日志，统计每个月搜索量.
 */
public class SearchNumByMonth {

    //月份
    private int month;
    //搜索量
    private int searchNum;


    public SearchNumByMonth()
    {

    }

    public SearchNumByMonth(int month, int searchNum) {
        this.month = month;
        this.searchNum = searchNum;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getSearchNum() {
        return searchNum;
    }

    public void setSearchNum(int searchNum) {
        this.searchNum = searchNum;
    }
}
