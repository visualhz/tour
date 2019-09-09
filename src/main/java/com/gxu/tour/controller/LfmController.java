package com.gxu.tour.controller;

import com.gxu.tour.service.LfmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LfmController
 * @Description TODO
 * @Author LLM
 * @Date 2019/9/5 9:15
 * @Version 1.0
 **/

@Controller
@RequestMapping("/Lfm")
public class LfmController {

    @Autowired
    private LfmService lfmService;

    //把用户的历史日志都写到指定目录，提供给LFM分析
    @GetMapping("/Wdata")
    public ModelAndView Wdata(HttpServletRequest request, HttpServletResponse response, Model model)
    {
        lfmService.writeDataLfm();
        return  null;
    }

    //把分析得到的lfm的P,Q矩阵写入本地
    @GetMapping("/WpqData")
    public ModelAndView WpqData(HttpServletRequest request, HttpServletResponse response, Model model)
    {
        lfmService.writePQdata();
        return  null;
    }

    //获取10个路线组合的推荐产品,根据用户ID
    @GetMapping("/GetRecDataOfRoute")
    @ResponseBody
    public Object GetRecDataOfRoute(HttpServletRequest request, HttpServletResponse response, Model model)
    {
//        String userID=request.getParameter("userID");
        String userID="103404";
        return  lfmService.getRouteRecID(userID);
    }

    //获取10个路线组合的推荐产品,根据热度推荐
    @GetMapping("/GetRecDataOfRouteByTop")
    @ResponseBody
    public Object GetRecDataOfRouteByTop(HttpServletRequest request, HttpServletResponse response, Model model)
    {
//        String userID=request.getParameter("userID");

        return  lfmService.getRouteByTop();
    }


}
