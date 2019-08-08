package com.gxu.tour.entity;

import java.util.Date;

public class User {
    private int id;
    private String uId;
    private String nickName;
    private String face;
    private int sex;
    private String city;
    private String openId;
    private String unionId;
    private Date createTime;

    public User()
    {
        super();
    }

    public User(int id, String uId, String nickName, String face, int sex, String city, String openId, String unionId, Date createTime) {
        this.id = id;
        this.uId = uId;
        this.nickName = nickName;
        this.face = face;
        this.sex = sex;
        this.city = city;
        this.openId = openId;
        this.unionId = unionId;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uId='" + uId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", face='" + face + '\'' +
                ", sex=" + sex +
                ", city='" + city + '\'' +
                ", openId='" + openId + '\'' +
                ", unionId='" + unionId + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
