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

    //返回用户的用户名和标识
    public List<Admin> getNameAndFlag();

    //修改用户密码
    public int alterAdmin(@Param("user") Admin user);

    //注册用户
    public int newAdmin(@Param("user") Admin user);

    //删除用户
    public int deleteAdmin(@Param("username") String username);


}

