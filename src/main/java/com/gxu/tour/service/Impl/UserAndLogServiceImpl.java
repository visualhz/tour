package com.gxu.tour.service.Impl;

import com.gxu.tour.entity.City;
import com.gxu.tour.entity.FromTerminal;
import com.gxu.tour.entity.Gender;
import com.gxu.tour.entity.Province;
import com.gxu.tour.mapper.UserAndLogMapping;
import com.gxu.tour.service.UserAndLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class UserAndLogServiceImpl implements UserAndLogService {


    @Autowired
    UserAndLogMapping userAndLogMapping;

    @Override
    public FromTerminal getCurrentFMData() {
        //获取当前年月
        Calendar calendar = Calendar.getInstance();
        //更新数据库应影响的行数
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int affect = 0;

        FromTerminal currentFMData = userAndLogMapping.getCurrentFMData();

        // 判断查询结果是否是当前月份的数据，如果数据库中没有，则进行数据统计，
        //如无数据更新则返回当前访问为0
        if (currentFMData == null || currentFMData.getYear() != year || currentFMData.getMonth() != month) {
            affect = userAndLogMapping.updateFMData(userAndLogMapping.doFMStatistic());
            System.out.println(affect);
            if (affect == 0)
                return new FromTerminal(1, 0, 0, 0, year, month);
            return userAndLogMapping.getCurrentFMData();
        }
        return currentFMData;
    }

    //统计访问设备来源数据
    @Override
    public FromTerminal doFMStatistic() {
        FromTerminal fmStatistic = userAndLogMapping.doFMStatistic();
        fmStatistic.setId(1);
        return fmStatistic;
    }

    //更新访问设备来源数据
    @Override
    public int updateFMData(FromTerminal data) {
        return userAndLogMapping.updateFMData(data);
    }

    //获取性别统计数据
    @Override
    public List<Gender> getGenderStatistics() {
        return userAndLogMapping.getGenderStatistics();
    }

    //进行性别数据统计，
    @Override
    public List<Gender> doGenderStatistics() {
        //  获取目前的年月时间
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        //返回数据的数目
        int size = 0;
        boolean isExisit = false;
        List<Gender> genders = userAndLogMapping.doGenderStatistics();

        //若无最近一年统计数据，则返回最近一年的数据都为0
        if (genders == null) {
            for (int i = 0; i < 12; i++) {
                genders.add(new Gender(i + 1, year, month, 0, 0, 0));
            }
            return genders;
        }
        size = genders.size();
        //若返回的数据不足12个月，则补足12条数据
        for (int i = 0; i < 12; i++) {
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
            isExisit = false;
            for (Gender gender : genders)
                if (year == gender.getYear() && (month + 1) == gender.getMonth()) {
                    isExisit = true;
                    break;
                }
            if (!isExisit)
                genders.add(new Gender((++size), year, month + 1, 0, 0, 0));
            calendar.add(Calendar.MONTH, -1);
        }
        return genders;
    }


    //更新性别统计数据库
    @Override
    public int updateGenderStatistics(List<Gender> genders) {
        return userAndLogMapping.updateGenderStatistics(genders);
    }


    //获取当月省份统计数据
    @Override
    public List<Province> getProvinceStatistics() {
        return userAndLogMapping.getProvinceStatistics();
    }

    //统计当月省份数据
    @Override
    public List<Province> doProvinceStatistics() {
        return userAndLogMapping.doProvinceStatistics();
    }

    //更新当月省份统计数据
    @Override
    public int updateProvinceStatistics(List<Province> provinces) {
        return userAndLogMapping.updateProvinceStatistics(provinces);
    }


    //获取注册用户来源城市统计数据
    @Override
    public List<City> getUserCityStatistics() {
        return userAndLogMapping.getUserCityStatistics();
    }

    //统计注册用户来源城市
    @Override
    public List<City> doUserCityStatistics() {
        List<City> cities = userAndLogMapping.doUserCityStatistics();
        for (int i = 0; i < 5; i++)
            cities.get(i).setId(i + 1);
        return cities;
    }

    //更新注册用户来源城市统计数据
    @Override
    public int updateUserCityStatistics(List<City> cities) {
        return userAndLogMapping.updateUserCityStatistics(cities);
    }
}
