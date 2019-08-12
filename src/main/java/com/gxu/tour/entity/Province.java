package com.gxu.tour.entity;

/**
 * provinceName: 省份
 * sum：当月来自此省份的人数
 */

public class Province {
    private int id;
    private String provinceName;
    private int sum;

    public Province() {
        super();
    }

    public Province(int id, String provinceName, int sum) {
        this.id = id;
        this.provinceName = provinceName;
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", provinceName='" + provinceName + '\'' +
                ", sum=" + sum +
                '}';
    }
}
