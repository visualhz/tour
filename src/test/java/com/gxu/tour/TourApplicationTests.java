package com.gxu.tour;


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
}
