package com.gxu.tour.service.Impl;

import com.gxu.tour.entity.Log;
import com.gxu.tour.entity.Route;
import com.gxu.tour.entity.RouteCount;
import com.gxu.tour.mapper.LfmMapper;
import com.gxu.tour.service.LfmService;
import com.gxu.tour.utils.LfmSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LfmServiceImpl
 * @Description TODO
 * @Author LLM
 * @Date 2019/8/29 18:12
 * @Version 1.0
 **/

@Service
public class LfmServiceImpl implements LfmService {
    @Autowired
    private LfmMapper lfmMapper;

    //把路线组合产品浏览日志写到本地
    @Override
    public void writeDataLfm() {

        //获取路线组合产品数据
        List<Log> datas=lfmMapper.getLfmData();
        //需要数据格式 user_id、product_id 、product_type 、product_name
        String filename="F:\\推荐算法\\datas\\route.csv";

        //判断文件是否存在，存在则删除
        File file=new File(filename);
        if(file.exists())
            file.delete();

        for (int i=0;i<datas.size();i++)
        {
            String content=datas.get(i).getUserId()+','+datas.get(i).getProductId()+','+datas.get(i).getProductType()
                    +','+datas.get(i).getProductName();
            method1(filename,content);
        }

    }

    //把P,Q矩阵写到本地
    @Override
    public String writePQdata() {
        String status=LfmSocket.getPredict("WPQ");
        return status;
    }

    //获取路线组合推荐产品ID
    @Override
    public String[] getRouteRecID(String userid) {
        //调用socket
        String[] datas=LfmSocket.getPredict(userid).trim().replaceAll("\\[","").replaceAll("\\]","").split(",");

        return datas;
    }

    //根据推荐的路线组合产品ID，去获取具体信息
    @Override
    public List<Route> getRouteRecById(String[] dataID) {
        List<Route> list=new ArrayList<Route>();

        //依次查询获取
        for(String value:dataID)
        {
            Route route=lfmMapper.getRouteRecById(value);
            list.add(route);
        }

        return list;
    }

    //获取前10的路线组合产品的具体信息
    @Override
    public List<Route> getRouteByTop() {
        //获取ID
        List<RouteCount> list=new ArrayList<RouteCount>();
        list =lfmMapper.getRouteByTop();
        //获取具体信息
        List<Route> list1=new ArrayList<Route>();
        for(RouteCount routeCount:list)
            list1.add(lfmMapper.getRouteRecById(routeCount.getProductId()));
        return list1;
    }

    //写文件
    public  void method1(String file, String conent) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true)));
            out.write(conent);
            out.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





}

