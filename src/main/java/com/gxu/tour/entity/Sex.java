package com.gxu.tour.entity;

/**
 * year:年
 * month:月
 * manNum:男性人数
 * womenNum:女性人数
 * total:总人数
 */
public class Sex {
    private int year;
    private int month;
    private int manNum;
    private int womenNum;
    private int total;

    public Sex()
    {
        super();
    }
    public Sex(int year, int month, int manNum, int womenNum, int total) {
        this.year = year;
        this.month = month;
        this.manNum = manNum;
        this.womenNum = womenNum;
        this.total = total;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getManNum() {
        return manNum;
    }

    public void setManNum(int manNum) {
        this.manNum = manNum;
    }

    public int getWomenNum() {
        return womenNum;
    }

    public void setWomenNum(int womenNum) {
        this.womenNum = womenNum;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Sex{" +
                "year=" + year +
                ", month=" + month +
                ", manNum=" + manNum +
                ", womenNum=" + womenNum +
                ", total=" + total +
                '}';
    }
}
