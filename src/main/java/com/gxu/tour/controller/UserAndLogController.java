package com.gxu.tour.controller;

import com.gxu.tour.entity.FromTerminal;
import com.gxu.tour.entity.Sex;
import com.gxu.tour.service.Impl.UserAndLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserAndLogController {

    @Autowired
    UserAndLogServiceImpl userAndLogService;

    @RequestMapping("/")
    public String index() {
        int i = userAndLogService.refreshFromTerminalStatistic();
        int i1 = userAndLogService.refreshSexByMonthStatistic();
        System.out.println(i + "," + i1);
        return "index";
    }

    /**
     * 返回当月访问的来源统计数据。
     */
    @ResponseBody
    @RequestMapping("/fromTerminal")
    public FromTerminal getFromTerminalStatistic() {
        FromTerminal formTerminalStatistic = userAndLogService.getFormTerminalStatistic();
        return formTerminalStatistic;
    }

    @ResponseBody
    @RequestMapping("/sex")
    public List<Sex> getSexStatistic() {
        return userAndLogService.getSexByMonthStatistic();
    }

    @RequestMapping("/visitor")
    public String hello(Model model) {
        FromTerminal statistic = userAndLogService.getFormTerminalStatistic();
        List<Sex> sexByMonthStatistic = userAndLogService.getSexByMonthStatistic();
        model.addAttribute("statistic", statistic);
        model.addAttribute("sBMS", sexByMonthStatistic);

        return "visitor";
    }


}
