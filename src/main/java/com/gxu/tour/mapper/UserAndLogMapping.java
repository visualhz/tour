package com.gxu.tour.mapper;

import com.gxu.tour.entity.City;
import com.gxu.tour.entity.FromTerminal;
import com.gxu.tour.entity.Gender;
import com.gxu.tour.entity.Province;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserAndLogMapping {
    //获取访问设备来源数据
    public FromTerminal getCurrentFMData();

    //获取和进行访问来源的统计
    public FromTerminal doFMStatistic();

    /**
     * 传递统计数据，更新统计数据结果表`from_terminal_result`。
     *
     * @param data 当月访问来源数据
     * @return
     */
    public int updateFMData(@Param("data") FromTerminal data);

    //获取按性别统计的最近一年的每月数据
    public List<Gender> getGenderStatistics();

    // 对过去一年游客访问进行性别统计，返回最近一年的统计数据
    public List<Gender> doGenderStatistics();

    /**
     * 对性别统计数据进行更新，更新的数据库表为`sexByMonth`
     *
     * @param genders 统计数据集合
     * @return
     */
    public int updateGenderStatistics(@Param("genders") List<Gender> genders);

    //获取归属省统计数据
    public List<Province> getProvinceStatistics();

    //进行归属省统计
    public List<Province> doProvinceStatistics();

    //更新归属省数据
    public int updateProvinceStatistics(@Param("provinces") List<Province> provinces);


    //获取注册用户来源城市统计数据
    public List<City> getUserCityStatistics();

    //进行注册用户来源城市统计
    public List<City> doUserCityStatistics();

    //更新注册用户来源城市统计数据
    public int updateUserCityStatistics(@Param("cities") List<City> cities);

}
