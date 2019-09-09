package com.gxu.tour.entity;

/**
 * @ClassName Log
 * @Description 实体类，记录日志数据
 * @Author LLM
 * @Date 2019/8/29 17:14
 * @Version 1.0
 **/
public class Log {

    private String userId;
    private String productType;
    private String productId;
    private String productName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
