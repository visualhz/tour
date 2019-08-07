package com.gxu.tour.mapper;

import com.gxu.tour.entity.Identity;
import com.gxu.tour.entity.Log;
import com.gxu.tour.entity.SoucreOfAccess;
import com.gxu.tour.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface UserAndLogMapping {


    //    获取单个用户
    public User getUserById(Integer id);

    //    查找全部用户
    public List<User> getAllUser();

    //  获取单个用户行为记录
    public Log getLogById(Integer id);

    //获取特定年月的访问源数量
    public SoucreOfAccess getNumbersOfAccessSource(@Param("year") int year, @Param("month") int month);

    public List<Identity> getVisitorIdentityStatistics();
}
