package com.gxu.tour.entity;

import java.util.Date;

public class Log {
//    `log_id``user_id``product_type``product_id`
//            `product_name``behavior_type``from_terminal``create_time`
    private Integer logId;
    private Integer userId;
    private String productType;
    private String productName;
    private String behaviorType;
    private String fromTerminal;
    private Date createTime;


    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBehaviorType() {
        return behaviorType;
    }

    public void setBehaviorType(String behaviorType) {
        this.behaviorType = behaviorType;
    }

    public String getFromTerminal() {
        return fromTerminal;
    }

    public void setFromTerminal(String fromTerminal) {
        this.fromTerminal = fromTerminal;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Log()
    {
        super();
    }

    public Log(Integer logId, Integer userId, String productType, String productName, String behaviorType, String fromTerminal, Date createTime) {
        this.logId = logId;
        this.userId = userId;
        this.productType = productType;
        this.productName = productName;
        this.behaviorType = behaviorType;
        this.fromTerminal = fromTerminal;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", userId=" + userId +
                ", productType='" + productType + '\'' +
                ", productName='" + productName + '\'' +
                ", behaviorType='" + behaviorType + '\'' +
                ", fromTerminal='" + fromTerminal + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}