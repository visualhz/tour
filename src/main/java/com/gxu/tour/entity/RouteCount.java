package com.gxu.tour.entity;

/**
 * @ClassName RouteCount
 * @Description 统计前10路线组合产品购买排行榜
 * @Author LLM
 * @Date 2019/9/5 15:58
 * @Version 1.0
 **/
public class RouteCount {
    private String productId;
    private String productName;
    private Integer num;

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
