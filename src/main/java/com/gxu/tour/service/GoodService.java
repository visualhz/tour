package com.gxu.tour.service;

import com.gxu.tour.entity.SearchNumByMonth;

import java.sql.Timestamp;
import java.util.List;

/**
 * Ceate By LLM 2019 08-07
 * Function: 产品数据分析服务类
 */
public interface GoodService {

    //分析用户搜索日志，统计指定月份记录数
    public Integer getSearchDataByTime(Timestamp start, Timestamp stop);

    //更新用户搜索日志结果表
    public void UpdateSearchData(List<SearchNumByMonth> searchNumByMonths);

    //获取用户搜索日志月份结果表数据,可以指定返回记录数，num
    public List<SearchNumByMonth> GetSearchDataForShow( Integer num);

}
