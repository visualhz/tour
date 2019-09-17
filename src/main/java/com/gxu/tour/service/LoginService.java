package com.gxu.tour.service;

import com.gxu.tour.entity.Admin;

import java.util.List;

public interface LoginService {
    //获取单个用户
    public Admin getAdmin(String username);

    //获取全部用户
    public List<Admin> getAllAdmin();

    //获取用户名和flag
    public List<Admin> getNameAndFlag();

    //修改用户密码
    public int alterAdmin(Admin user);

    //注册用户
    public int newAdmin(Admin user);

    public int deleteAdmin(String username);


}
