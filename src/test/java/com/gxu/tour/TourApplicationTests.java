package com.gxu.tour;


import com.gxu.tour.entity.Rank;
import com.gxu.tour.entity.SearchNumByMonth;
import com.gxu.tour.mapper.GoodMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TourApplicationTests {

    @Autowired
    private GoodMapper mapper;

    //测试时间查询
    @Test
    public void one()
    {
        Timestamp start=Timestamp.valueOf("2019-02-01 00:00:00");
        Timestamp stop=Timestamp.valueOf("2019-03-01 00:00:00");
        int count=mapper.getSearchDataByTime(start,stop);
        System.out.println(count);
    }

    //测试更新数据
    @Test
    public void two()
    {
        SearchNumByMonth one=new SearchNumByMonth(1,13);
        SearchNumByMonth two=new SearchNumByMonth(2,10);
        List<SearchNumByMonth> list=new ArrayList<SearchNumByMonth>();
        list.add(one);
        list.add(two);
        mapper.UpdateSearchData(list);
    }

    //测试查询数据
    @Test
    public void third()
    {

        for(SearchNumByMonth searchNumByMonth:mapper.GetSearchDataForShow(8))
        {
            System.out.println("月份："+searchNumByMonth.getMonth()+"数量: "+searchNumByMonth.getSearchNum());
        }
//        System.out.println(mapper.GetSearchDataForShow(8));
    }
     /////////////////////////////////////////////////
    //测试时间查询
    @Test
    public void four()
    {
        Timestamp start=Timestamp.valueOf("2019-02-01 00:00:00");
        Timestamp stop=Timestamp.valueOf("2019-03-01 00:00:00");
        int count=mapper.getWatchDataByTime(start,stop);
        System.out.println(count);
    }

    //测试更新数据
    @Test
    public void five()
    {
        SearchNumByMonth one=new SearchNumByMonth(1,13);
        SearchNumByMonth two=new SearchNumByMonth(2,10);
        List<SearchNumByMonth> list=new ArrayList<SearchNumByMonth>();
        list.add(one);
        list.add(two);
        mapper.UpdateWatchData(list);
    }

    //测试查询数据
    @Test
    public void six()
    {

        for(SearchNumByMonth searchNumByMonth:mapper.GetWatchDataForShow(8))
        {
            System.out.println("月份："+searchNumByMonth.getMonth()+"数量: "+searchNumByMonth.getSearchNum());
        }
//        System.out.println(mapper.GetSearchDataForShow(8));
    }
    ////////////////////////////////////////////////////////////
    //测试查询数据,搜索日志排行
    @Test
    public void seven()
    {

        for(Rank rank:mapper.getSearchRankData())
        {
            System.out.println("名称："+rank.getName()+"数量: "+rank.getNum());
        }

    }

    //测试更新排行数据
    @Test
    public void eight()
    {
        Rank one=new Rank(1,"llm",13);
        Rank two=new Rank(2,"ss",103);
        List<Rank> list=new ArrayList<Rank>();
        list.add(one);
        list.add(two);
        mapper.UpdateSearchRankData(list);
    }

    //测试获取排行数据
    @Test
    public void night()
    {
        for(Rank rank:mapper.GetSearchRankDataForShow())
        {
            System.out.println(rank.getName()+rank.getNum());
        }
    }
    ///////////////////////////////////////////////////////////////////
    //测试浏览日志排行统计
    @Test
    public void t1()
    {

        for(Rank rank:mapper.getWatchRankData())
        {
            System.out.println("名称："+rank.getName()+"数量: "+rank.getNum());
        }

    }

    @Test
    public void t2()
    {
        Rank one=new Rank(1,"llm",13);
        Rank two=new Rank(2,"ss",103);
        List<Rank> list=new ArrayList<Rank>();
        list.add(one);
        list.add(two);
        mapper.UpdateWatchRankData(list);
    }

    //测试获取排行数据
    @Test
    public void t3()
    {
        for(Rank rank:mapper.GetWatchRankDataForShow())
        {
            System.out.println(rank.getName()+rank.getNum());
        }
    }

}
