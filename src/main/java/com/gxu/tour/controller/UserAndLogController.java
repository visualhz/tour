package com.gxu.tour.controller;

import com.gxu.tour.entity.Identity;
import com.gxu.tour.entity.Log;
import com.gxu.tour.entity.SoucreOfAccess;
import com.gxu.tour.entity.User;
import com.gxu.tour.service.Impl.UserAndLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserAndLogController {

    private int year = 2017;
    private int month = 1;

    @Autowired
    UserAndLogServiceImpl userAndLogService;


    @RequestMapping("/")
    public String index(Model model) {
        Calendar cal = Calendar.getInstance();
//        year = cal.get(Calendar.YEAR);
//        month = cal.get(Calendar.MONTH) + 1;
        //        获取单个用户
        User user = userAndLogService.getUserById(100001);
        //        获取单个用户记录
        Log log = userAndLogService.getLogById(1);
        //        获取当月访问来源统计
        SoucreOfAccess soucreOfAccess = userAndLogService.getNumbersOfAccessSource(year, month);
        //        获取最近一年每个月的访问量和男女人数
        List<Identity> visitorIS = userAndLogService.getVisitorIdentityStatistics();


        visitorIS.forEach(identity -> System.out.println(identity.getYearAndMonth()));
        if (soucreOfAccess != null)
            System.out.println(soucreOfAccess);


        model.addAttribute("usr", user);
        model.addAttribute("log", log);
        model.addAttribute("visitorIS", visitorIS);
        return "index";
    }

    @RequestMapping("/visitor")
    public String hello() {
        return "visitor";
    }


}
