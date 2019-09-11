package com.gxu.tour.service;

import com.gxu.tour.entity.Route;
import com.gxu.tour.entity.Scene;

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

    //获取前10的路线组合产品的具体信息，用于未登陆用户
    public List<Route> getRouteByTop();

    //-----------分割线，以下是景点推荐的
    //把景点产品浏览日志写到本地
    public void writeSceneData();

    //把P,Q矩阵写到本地
    public String writeScenePQdata();

    //获取推荐产品,景点推荐
    public String[] getSceneRecID(String userid);

    //根据推荐的路线组合产品ID，去获取具体信息
    public List<Scene> getSceneRecById(String[] dataID);

    //获取前10的景点的具体信息，用于未登陆用户
    public List<Scene> getSceneByTop();
}
