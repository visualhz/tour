package com.gxu.tour.service;

import com.gxu.tour.entity.Route;

import java.util.List;

/**
 * @ClassName LfmService
 * @Description TODO
 * @Author LLM
 * @Date 2019/8/29 18:12
 * @Version 1.0
 **/

public interface LfmService {

    //把路线组合产品浏览日志写到本地
    public void writeDataLfm();

    //把P,Q矩阵写到本地
    public String writePQdata();

    //获取推荐产品
    public String[] getRouteRecID(String userid);

    //根据推荐的路线组合产品ID，去获取具体信息
    public List<Route> getRouteRecById(String[] dataID);

    //获取前10的路线组合产品的具体信息
    public List<Route> getRouteByTop();
}
