package com.gxu.tour.service;

import com.gxu.tour.entity.Identity;
import com.gxu.tour.entity.Log;
import com.gxu.tour.entity.SoucreOfAccess;
import com.gxu.tour.entity.User;


import java.util.List;


public interface UserAndLogService {
    // 获取单个用户行为记录
    public Log getLogById(Integer id);

    /**
     * 获取当月的访问来源统计数据
     * 返回值：
     * MP：小程序访问游客数量
     * PC: 电脑客户端访问游客数量
     */

    public SoucreOfAccess getNumbersOfAccessSource(int year, int month);

    //获取单个用户
    public User getUserById(Integer id);

    /**
     * 返回全部用户的集合
     */
    public List<User> getUsers();


    /**
     * 统计最近一年每个月访问游客身份数据
     * 返回从当前距离过去最近12个月数据
     * 返回值
     * total：每个月访问的总人数
     * mnumber:每个月访问的男性总人数
     * wnumber：每个月访问的女性总人数
     * mon：返回年份和月份
     */
    public List<Identity> getVisitorIdentityStatistics();

}
