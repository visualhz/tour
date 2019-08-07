package com.gxu.tour.service.Impl;

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
}
