package com.gxu.tour.controller;

import com.gxu.tour.entity.Route;
import com.gxu.tour.service.LfmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 获取10个路线组合的推荐产品,根据用户ID
     * @param userID 用户名
     * @param request
     * @return
     */
    @GetMapping("/GetRecDataOfRoute")
    @ResponseBody
    public Object GetRecDataOfRoute(@RequestParam(value = "userID") String userID, HttpServletRequest request, HttpServletResponse response, Model model)
    {
//        String userID=request.getParameter("userID");
//        String userID="103404";
//        return  lfmService.getRouteRecID(userID);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        String[] productId = lfmService.getRouteRecID(userID);
        List<Route> routes = lfmService.getRouteRecById(productId);
        Map<String,List<Route>> recommendRotesMap = new HashMap<>();
        recommendRotesMap.put("routes",routes);
        return  recommendRotesMap;
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
