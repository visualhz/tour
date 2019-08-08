package com.gxu.tour.service.Impl;

import com.gxu.tour.entity.Rank;
import com.gxu.tour.entity.SearchNumByMonth;
import com.gxu.tour.mapper.GoodMapper;
import com.gxu.tour.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

/**
 * Ceate By LLM 2019 08-07
 * Function: 产品数据分析服务实现类
 */
@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    //商品数据库操作类
    private GoodMapper goodMapper;

    //分析用户搜索日志，统计指定月份记录数
    @Override
    public Integer getSearchDataByTime(Timestamp start,Timestamp stop) {
        return goodMapper.getSearchDataByTime(start,stop);
    }

    //更新用户搜索日志结果表
    @Override
    public void UpdateSearchData(List<SearchNumByMonth> searchNumByMonths) {
        goodMapper.UpdateSearchData(searchNumByMonths);
    }

    //获取用户搜索日志月份结果表数据,可以指定返回记录数，num
    @Override
    public List<SearchNumByMonth> GetSearchDataForShow(Integer num) {
        return goodMapper.GetSearchDataForShow(num);
    }

    //分析用户浏览日志，统计指定月份记录数
    @Override
    public Integer getWatchDataByTime(Timestamp start, Timestamp stop) {
        return goodMapper.getWatchDataByTime(start,stop);
    }

    //更新用户浏览日志结果表
    @Override
    public void UpdateWatchData(List<SearchNumByMonth> searchNumByMonths) {
        goodMapper.UpdateWatchData(searchNumByMonths);
    }

    //获取用户搜索日志月份结果表数据,可以指定返回记录数，num
    @Override
    public List<SearchNumByMonth> GetWatchDataForShow(Integer num) {
        return goodMapper.GetWatchDataForShow(num);
    }

    //********************分割线，用户搜索日志排行榜*************************
    //获取最近一个月，用户搜索日志表的搜索排行
    @Override
    public List<Rank> getSearchRankData() {
        return goodMapper.getSearchRankData();
    }

    //更新用户搜索日志表的搜索排行结果表
    @Override
    public void UpdateSearchRankData(List<Rank> ranks) {
        goodMapper.UpdateSearchRankData(ranks);
    }

    //获取用户搜索日志排行结果表数据
    @Override
    public List<Rank> GetSearchRankDataForShow() {
        return goodMapper.GetSearchRankDataForShow();
    }

    //********************分割线，用户浏览日志排行榜*************************
    //获取最近一个月，用户搜索日志表的搜索排行
    @Override
    public List<Rank> getWatchRankData() {
        return goodMapper.getWatchRankData();
    }

    //更新用户搜索日志表的搜索排行结果表
    @Override
    public void UpdateWatchRankData(List<Rank> ranks) {
        goodMapper.UpdateWatchRankData(ranks);
    }

    //获取用户搜索日志排行结果表数据
    @Override
    public List<Rank> GetWatchRankDataForShow() {
        return goodMapper.GetWatchRankDataForShow();
    }


}
