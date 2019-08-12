package com.gxu.tour.service;

import com.gxu.tour.entity.City;
import com.gxu.tour.entity.FromTerminal;
import com.gxu.tour.entity.Gender;
import com.gxu.tour.entity.Province;

import javax.crypto.Cipher;
import java.util.List;

public interface UserAndLogService {
    //获取访问设备来源数据
    public FromTerminal getCurrentFMData();

    //进行访问设备来源数据统计
    public FromTerminal doFMStatistic();

    // 更新访问设备来源数据库
    public int updateFMData(FromTerminal data);

    //获取性别统计数据
    public List<Gender> getGenderStatistics();

    //进行性别统计
    public List<Gender> doGenderStatistics();

    // 更新性别统计数据库
    public int updateGenderStatistics(List<Gender> genders);

    //获取当月省份统计数据
    public List<Province> getProvinceStatistics();

    //进行当月省份数据统计
    public List<Province> doProvinceStatistics();

    //更细当月省份统计数据
    public int updateProvinceStatistics(List<Province> provinces);


    //获取注册用户来源城市统计数据
    public List<City> getUserCityStatistics();

    //统计注册用户来源城市
    public List<City> doUserCityStatistics();

    //更新注册用户来源城市统计数据
    public int updateUserCityStatistics(List<City> cities);
}
