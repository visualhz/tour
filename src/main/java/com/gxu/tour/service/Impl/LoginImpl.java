package com.gxu.tour.service.Impl;

import com.gxu.tour.entity.Admin;
import com.gxu.tour.mapper.LoginMapper;
import com.gxu.tour.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    //获取单个用户
    @Override
    public Admin getAdmin(String username) {
        Admin admin = loginMapper.getAdmin(username);
        return admin;
    }

    //获取全部用户
    @Override
    public List<Admin> getAllAdmin() {
        return loginMapper.getAllAdmin();
    }

    //修改用户密码
    @Override
    public int alterAdmin(Admin user) {
        return loginMapper.alterAdmin(user);
    }

    //注册用户
    @Override
    public int newAdmin(Admin user) {

        return loginMapper.newAdmin(user);
    }

}
