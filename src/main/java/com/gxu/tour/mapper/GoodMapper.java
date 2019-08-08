package com.gxu.tour.mapper;

import com.gxu.tour.entity.Rank;
import com.gxu.tour.entity.SearchNumByMonth;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Ceate By LLM 2019 08-07
 * Function: 产品数据分析数据库操作类，DAO层
 */
@Repository
public interface GoodMapper {

    /**
     * 指定年月查询数据
     * start 为开始月份
     * stop 为结束月份
     */
    public Integer getSearchDataByTime(@Param("start") Timestamp start, @Param("stop") Timestamp stop);

    /**
     * 把每个月的搜索量结果数据，更新到结果表
     * 参数为List，批量更新
     */
    public void UpdateSearchData(@Param("searchNumByMonths") List<SearchNumByMonth> searchNumByMonths);

    //获取用户搜索日志月份结果表数据,可以指定返回记录数，num
    public List<SearchNumByMonth> GetSearchDataForShow(@Param("num") Integer num);

    /**
     * 指定年月查询数据
     * start 为开始月份
     * stop 为结束月份
     */
    public Integer getWatchDataByTime(@Param("start") Timestamp start, @Param("stop") Timestamp stop);

    /**
     * 把每个月的搜索量结果数据，更新到结果表
     * 参数为List，批量更新
     */
    public void UpdateWatchData(@Param("searchNumByMonths") List<SearchNumByMonth> searchNumByMonths);

    //获取用户搜索日志月份结果表数据,可以指定返回记录数，num
    public List<SearchNumByMonth> GetWatchDataForShow(@Param("num") Integer num);

    //**************************分割线，以下是排行榜，用户搜索日志的排行榜，用户浏览日志的排行榜***********************************

    //获取最近一个月，用户搜索日志表的搜索排行
    public List<Rank> getSearchRankData();

    //更新用户搜索排行结果表
    public void UpdateSearchRankData(@Param("ranks") List<Rank> ranks);

    //获取用户搜索排行结果表数据
    public List<Rank> GetSearchRankDataForShow();

    //***************************以下是用户浏览日志***********************************************

    //获取最近一个月，用户浏览日志表的排行
    public List<Rank> getWatchRankData();

    //更新用户浏览排行结果表
    public void UpdateWatchRankData(@Param("ranks") List<Rank> ranks);

    //获取用户浏览排行结果表数据
    public List<Rank> GetWatchRankDataForShow();
}
