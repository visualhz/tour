package com.gxu.tour.entity;

/**
 * 用户实体类
 */

public class User {

    private Integer userId;
    private String userName;
    private String userSex;
    private int userAge;
    private String province;

    public User()
    {
        super();
    }

    public User(Integer userId, String userName, String userSex, int userAge, String province) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userAge = userAge;
        this.province = province;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userAge=" + userAge +
                ", province='" + province + '\'' +
                '}';
    }
}
