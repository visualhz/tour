package com.gxu.tour.entity;

/**
 * year:年
 * month:月
 * MP：小程序
 * PC：客户端
 * IM：一体机
 */

public class FromTerminal {
    private int year;
    private int month;
    private int MP;
    private int PC;
    private int IM;

    public FromTerminal() {
        super();
    }

    public FromTerminal(int year, int month, int MP, int PC, int IM) {
        this.year = year;
        this.month = month;
        this.MP = MP;
        this.PC = PC;
        this.IM = IM;
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

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getPC() {
        return PC;
    }

    public void setPC(int PC) {
        this.PC = PC;
    }

    public int getIM() {
        return IM;
    }

    public void setIM(int IM) {
        this.IM = IM;
    }

    @Override
    public String toString() {
        return "FromTerminal{" +
                "year=" + year +
                ", month=" + month +
                ", MP=" + MP +
                ", PC=" + PC +
                ", IM=" + IM +
                '}';
    }
}
