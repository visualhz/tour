package com.gxu.tour.controller;

import com.gxu.tour.entity.City;
import com.gxu.tour.entity.FromTerminal;
import com.gxu.tour.entity.Gender;
import com.gxu.tour.entity.Province;
import com.gxu.tour.service.Impl.UserAndLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserAndLogController {

    @Autowired
    UserAndLogServiceImpl userAndLogService;

    // 进行数据更新
    @RequestMapping("/refreshVisitor")
    public String refreshVisitor() {
        try {
            userAndLogService.updateFMData(userAndLogService.doFMStatistic());
            userAndLogService.updateUserCityStatistics(userAndLogService.doUserCityStatistics());
            userAndLogService.updateGenderStatistics(userAndLogService.doGenderStatistics());
            userAndLogService.updateProvinceStatistics(userAndLogService.doProvinceStatistics());
        } catch (Exception e) {
            return "visitor";
        }
        return "visitor";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    //返回访问来源设备json数据
    @ResponseBody
    @RequestMapping("/api/getCurrentFMData")
    public FromTerminal getCurrentFMData() {
        return userAndLogService.getCurrentFMData();
    }


    //更新访问设备来源数据
    @RequestMapping("/api/updateFMData")
    public int updateFMData() {
        FromTerminal data = userAndLogService.doFMStatistic();
        int affect = userAndLogService.updateFMData(data);
        return affect;
    }

    //获取性别统计json数据
    @ResponseBody
    @RequestMapping("/api/getGenderStatistics")
    public List<Gender> getGenderStatistics() {
        return userAndLogService.getGenderStatistics();
    }


    //更新性别统计数据库
    @RequestMapping("/api/updateGenderStatistics")
    public int updateGenderStatistics() {
        int affect = userAndLogService.updateGenderStatistics(userAndLogService.doGenderStatistics());
        return affect;
    }


    //获取当前月份浏览用户来源省份json数据
    @ResponseBody
    @RequestMapping("/api/getProvinceStatistics")
    public List<Province> getProvinceStatistics() {
        return userAndLogService.getProvinceStatistics();
    }


    //更新当前月份浏览用户来源省份数据
    @RequestMapping("/api/updateProvinceStatistics")
    public int updateProvinceStatistics() {
        return userAndLogService.updateProvinceStatistics(userAndLogService.doProvinceStatistics());
    }


    //获取注册用户来源城市统计json数据
    @ResponseBody
    @RequestMapping("/api/getUserCityStatistics")
    public List<City> getUserCityStatistics() {
        return userAndLogService.getUserCityStatistics();
    }


    //更新注册用户来源城市统计数据
    @RequestMapping("/api/updateUserCityStatistics")
    public int updateUserCityStatistics() {
        return userAndLogService.updateUserCityStatistics(userAndLogService.doUserCityStatistics());
    }


    @RequestMapping("/visitor")
    public String visitor() {
        return "visitor";
    }

    @RequestMapping("/goodData")
    public String goodData() {
        return "goodData";
    }


}
