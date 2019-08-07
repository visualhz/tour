package com.gxu.tour.entity;

import java.util.Date;

public class Identity {
    private int total;
    private int mNumber;
    private int wNumber;
    private Date yearAndMonth;

    public Identity()
    {
        super();
    }
    public Identity(int total, int mNumber, int wNumber, Date yearAndMonth) {
        this.total = total;
        this.mNumber = mNumber;
        this.wNumber = wNumber;
        this.yearAndMonth = yearAndMonth;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getmNumber() {
        return mNumber;
    }

    public void setmNumber(int mNumber) {
        this.mNumber = mNumber;
    }

    public int getwNumber() {
        return wNumber;
    }

    public void setwNumber(int wNumber) {
        this.wNumber = wNumber;
    }

    public Date getYearAndMonth() {
        return yearAndMonth;
    }

    public void setYearAndMonth(Date yearAndMonth) {
        this.yearAndMonth = yearAndMonth;
    }

    @Override
    public String toString() {
        return "Identity{" +
                "total=" + total +
                ", mNumber=" + mNumber +
                ", wNumber=" + wNumber +
                ", yearAndMonth=" + yearAndMonth +
                '}';
    }
}
