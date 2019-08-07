package com.gxu.tour.entity;

public class SoucreOfAccess {
    private int MP;
    private int PC;

    public SoucreOfAccess() {
    super();
    }

    public SoucreOfAccess(int MP, int PC) {
        this.MP = MP;
        this.PC = PC;
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

    @Override
    public String toString() {
        return "SoucreOfAccess{" +
                "MP=" + MP +
                ", PC=" + PC +
                '}';
    }
}
