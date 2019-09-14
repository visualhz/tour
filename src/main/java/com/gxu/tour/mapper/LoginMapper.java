package com.gxu.tour.mapper;

import com.gxu.tour.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LoginMapper {
    //获取单个用户
    public Admin getAdmin(@Param("username") String username);

    //获取全部用户
    public List<Admin> getAllAdmin();

    //修改用户密码
    public int alterAdmin(@Param("user") Admin user);

    //注册用户
    public int newAdmin(@Param("user") Admin user);


}

