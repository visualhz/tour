package com.gxu.tour.entity;

/**
 * 用户实体类
 * username：用户名，
 * password：密码，
 * flag：用户身份标识，1为超级管理员用户，0为普通用户。
 */
public class Admin {
    private String userName;
    private String password;
    private int flag;

    public Admin() {
        super();
    }

    public Admin(String userName) {
        this.userName = userName;
    }

    public Admin(String userName, String password, int flag) {
        this.userName = userName;
        this.password = password;
        this.flag = flag;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", flag=" + flag +
                '}';
    }
}
