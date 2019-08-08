package com.gxu.tour.entity;

import java.util.Date;

public class WatchLog {

    private int id;
    private String uId;
    private int fromTerminal;
    private String tourId;
    private String tourName;
    private Date createTime;

    public WatchLog() {
        super();
    }

    public WatchLog(int id, String uId, int fromTerminal, String tourId, String tourName, Date createTime) {
        this.id = id;
        this.uId = uId;
        this.fromTerminal = fromTerminal;
        this.tourId = tourId;
        this.tourName = tourName;
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

    public int getFromTerminal() {
        return fromTerminal;
    }

    public void setFromTerminal(int fromTerminal) {
        this.fromTerminal = fromTerminal;
    }

    public String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "WatchLog{" +
                "id=" + id +
                ", uId='" + uId + '\'' +
                ", fromTerminal=" + fromTerminal +
                ", tourId='" + tourId + '\'' +
                ", tourName='" + tourName + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
