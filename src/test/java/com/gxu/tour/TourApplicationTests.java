package com.gxu.tour;


import com.gxu.tour.entity.*;
import com.gxu.tour.mapper.GoodMapper;
import com.gxu.tour.mapper.UserAndLogMapping;
import com.gxu.tour.service.Impl.UserAndLogServiceImpl;
import com.gxu.tour.service.UserAndLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.LinkedList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TourApplicationTests {

    @Autowired
    private UserAndLogMapping userAndLogMapping;

    @Autowired
    private GoodMapper mapper;

    //测试时间查询
    @Test
    public void one() {
        Timestamp start = Timestamp.valueOf("2019-02-01 00:00:00");
        Timestamp stop = Timestamp.valueOf("2019-03-01 00:00:00");
        int count = mapper.getSearchDataByTime(start, stop);
        System.out.println(count);
    }

    //测试更新数据
    @Test
    public void two() {
        SearchNumByMonth one = new SearchNumByMonth(1, 13);
        SearchNumByMonth two = new SearchNumByMonth(2, 10);
        List<SearchNumByMonth> list = new ArrayList<SearchNumByMonth>();
        list.add(one);
        list.add(two);
        mapper.UpdateSearchData(list);
    }

    //测试查询数据
    @Test
    public void third() {

        for (SearchNumByMonth searchNumByMonth : mapper.GetSearchDataForShow(8)) {
            System.out.println("月份：" + searchNumByMonth.getMonth() + "数量: " + searchNumByMonth.getSearchNum());
        }
//        System.out.println(mapper.GetSearchDataForShow(8));
    }

    /////////////////////////////////////////////////
    //测试时间查询
    @Test
    public void four() {
        Timestamp start = Timestamp.valueOf("2019-02-01 00:00:00");
        Timestamp stop = Timestamp.valueOf("2019-03-01 00:00:00");
        int count = mapper.getWatchDataByTime(start, stop);
        System.out.println(count);
    }

    //测试更新数据
    @Test
    public void five() {
        SearchNumByMonth one = new SearchNumByMonth(1, 13);
        SearchNumByMonth two = new SearchNumByMonth(2, 10);
        List<SearchNumByMonth> list = new ArrayList<SearchNumByMonth>();
        list.add(one);
        list.add(two);
        mapper.UpdateWatchData(list);
    }

    //测试查询数据
    @Test
    public void six() {

        for (SearchNumByMonth searchNumByMonth : mapper.GetWatchDataForShow(8)) {
            System.out.println("月份：" + searchNumByMonth.getMonth() + "数量: " + searchNumByMonth.getSearchNum());
        }
//        System.out.println(mapper.GetSearchDataForShow(8));
    }

    ////////////////////////////////////////////////////////////
    //测试查询数据,搜索日志排行
    @Test
    public void seven() {

        for (Rank rank : mapper.getSearchRankData()) {
            System.out.println("名称：" + rank.getName() + "数量: " + rank.getNum());
        }

    }

    //测试更新排行数据
    @Test
    public void eight() {
        Rank one = new Rank(1, "llm", 13);
        Rank two = new Rank(2, "ss", 103);
        List<Rank> list = new ArrayList<Rank>();
        list.add(one);
        list.add(two);
        mapper.UpdateSearchRankData(list);
    }

    //测试获取排行数据
    @Test
    public void night() {
        for (Rank rank : mapper.GetSearchRankDataForShow()) {
            System.out.println(rank.getName() + rank.getNum());
        }
    }

    ///////////////////////////////////////////////////////////////////
    //测试浏览日志排行统计
    @Test
    public void t1() {

        for (Rank rank : mapper.getWatchRankData()) {
            System.out.println("名称：" + rank.getName() + "数量: " + rank.getNum());
        }

    }

    @Test
    public void t2() {
        Rank one = new Rank(1, "llm", 13);
        Rank two = new Rank(2, "ss", 103);
        List<Rank> list = new ArrayList<Rank>();
        list.add(one);
        list.add(two);
        mapper.UpdateWatchRankData(list);
    }

    //测试获取排行数据
    @Test
    public void t3() {
        for (Rank rank : mapper.GetWatchRankDataForShow()) {
            System.out.println(rank.getName() + rank.getNum());
        }
    }

    @Test
    public void testt() {
        String[] last12Months = new String[12];
        Calendar cal = Calendar.getInstance();
        //如果当前日期大于二月份的天数28天或者29天会导致计算月份错误，会多出一个三月份，故设置一个靠前日期解决此问题
        cal.set(2019, 0, 1);
        for (int i = 0; i < 12; i++) {
            last12Months[11 - i] = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1);
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1); //逐次往前推1个月
        }
        for (int i = 0; i < last12Months.length; i++) {
            System.out.println(last12Months[i]);
        }
    }

    @Test
    public void testGetGenderStatistics() {
        List<Gender> genderStatistics = userAndLogMapping.getGenderStatistics();
        genderStatistics.forEach(e -> System.out.println(e));
    }


    @Test
    public void testDoGenderStatistics() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int size = 0;
        List<Gender> genders = userAndLogMapping.doGenderStatistics();
        if (genders == null) {
            for (int i = 0; i < 12; i++) {
                genders.add(new Gender(i + 1, year, month, 0, 0, 0));
            }
            return;
        }
        size = genders.size();
        if (size < 12) {
            year = genders.get((size - 1)).getYear();
            month = genders.get(size - 1).getMonth();
            calendar.set(year, month, 1);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);

            for (int i = 0; i < 12 - size; i++) {
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                genders.add(new Gender((size + i + 1), year, month + 1, 0, 0, 0));
                calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
            }
        }
        genders.forEach(e -> System.out.println(e));
        int affect = userAndLogMapping.updateGenderStatistics(genders);
        System.out.println(affect);
    }


    @Test
    public void testUpdateGenderStatistics() {
        List<Province> provinces = userAndLogMapping.doProvinceStatistics();
        userAndLogMapping.updateProvinceStatistics(provinces);
        List<Province> provinceStatistics = userAndLogMapping.getProvinceStatistics();
        provinceStatistics.forEach(e -> System.out.println(e));

    }


    @Test
    public void testUserCity() {
        List<City> userCityStatistics = userAndLogMapping.getUserCityStatistics();
        userCityStatistics.forEach(e -> System.out.println(e));
        List<City> cities = userAndLogMapping.doUserCityStatistics();
        for (int i = 0; i < 5; i++ )
            cities.get(i).setId(i+1);
        cities.forEach(e-> System.out.println(e));
        userAndLogMapping.updateUserCityStatistics(cities);

    }

    @Test
    public void testStudy()
    {
        String s1;
        StringBuilder s;
        StringBuffer s2;
    }

    @Test
    public void testSha256()
    {
        System.out.println(userAndLogMapping.doGenderStatistics());
    }



}
