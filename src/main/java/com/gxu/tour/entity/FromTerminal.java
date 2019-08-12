package com.gxu.tour.entity;

/**
 * MP：小程序
 * PC：客户端
 * IM：一体机
 */

public class FromTerminal {
    int id;
    int PC;
    int MP;
    int IM;
    int year;
    int month;

    public FromTerminal() {
        super();
    }

    public FromTerminal(int id, int PC, int MP, int IM, int year, int month) {
        this.id = id;
        this.PC = PC;
        this.MP = MP;
        this.IM = IM;
        this.year = year;
        this.month = month;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPC() {
        return PC;
    }

    public void setPC(int PC) {
        this.PC = PC;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
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
                "id=" + id +
                ", PC=" + PC +
                ", MP=" + MP +
                ", IM=" + IM +
                ", year=" + year +
                ", month=" + month +
                '}';
    }
}
