package com.gxu.tour.controller;

import com.gxu.tour.entity.SearchNumByMonth;
import com.gxu.tour.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Ceate By LLM 2019 08-07
 * Function: 产品数据分析逻辑类
 */
@Controller
@RequestMapping("/Good")
public class GoodController {

    @Autowired
    private GoodService goodService;

    /**
     * 统计用户搜索日志，每个月的访问量，然后更新到结果表中去
     * 逻辑：只统计当前年，和目前月份的之前月份，使用SearchNumByMonth类记载统计结果，然后插入结果表
     */
    @GetMapping("/UpDateSeachByTime")
    public ModelAndView insertSexandMonthResult(HttpServletRequest request, HttpServletResponse response, Model model)
    {
        //创建集合，存储结果类
        List<SearchNumByMonth> sms=new ArrayList<SearchNumByMonth>();
        //获取当前年、月
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        //组装日期格式 因为查询日期格式要求如："2019-02-01 00:00:00" 日期格式为 year+monthPart
        String[] monthPart={"-01-01 00:00:00","-02-01 00:00:00","-03-01 00:00:00","-04-01 00:00:00",
                "-05-01 00:00:00","-06-01 00:00:00","-07-01 00:00:00","-08-01 00:00:00",
                "-09-01 00:00:00","-10-01 00:00:00","-11-01 00:00:00","-12-01 00:00:00"};
        //根据当前月份获取以前的月份
        for(int i=1;i<=month;i++)
        {
            //结果类
            SearchNumByMonth searchNumByMonth=new SearchNumByMonth();
            //设置当前月份为结果类ID
            searchNumByMonth.setMonth(i);
            //设置开始时间，结束水煎
            Timestamp start = Timestamp.valueOf(year + monthPart[i-1]);
            //设置结束时间
            Timestamp stop=null;
            //如果求12月份，年加1
            if(i!=12)
            {
                stop = Timestamp.valueOf(year + monthPart[i]);
            }
            else
            {
                stop = Timestamp.valueOf((year+1) + monthPart[0]);
            }
            //获取统计数据
            searchNumByMonth.setSearchNum(goodService.getSearchDataByTime(start,stop));
            //添加进集合
            sms.add(searchNumByMonth);

        }
        //测试输出
        for (int i=0;i<sms.size();i++)
        {
            System.out.println("月份"+sms.get(i).getMonth()+" 数量="+sms.get(i).getSearchNum());
        }

        //更新数据
        goodService.UpdateSearchData(sms);
       return null;
    }

    //获取用户搜索日志，每月统计量来展示
    @GetMapping("/GetSearchDataForShow")
    public ModelAndView GetSearchDataForShow(HttpServletRequest request, HttpServletResponse response, Model model)
    {
        //获取月，用来限制从结果表取回几条数据，8月就去前8条数据
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;

        //获取数据
        List<SearchNumByMonth> searchNumByMonths=goodService.GetSearchDataForShow(month);

        for(SearchNumByMonth searchNumByMonth:searchNumByMonths)
        {
            System.out.println("月份："+searchNumByMonth.getMonth()+"数量: "+searchNumByMonth.getSearchNum());
        }

        return  null;
    }
}
