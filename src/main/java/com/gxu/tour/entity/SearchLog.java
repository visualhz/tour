package com.gxu.tour.entity;

import java.util.Date;

public class SearchLog {
    private int id;
    private String uId;
    private int fromTerminal;
    private String searchTitle;
    private Date createTime;

    public SearchLog() {
        super();
    }

    public SearchLog(int id, String uId, int fromTerminal, String searchTitle, Date createTime) {
        this.id = id;
        this.uId = uId;
        this.fromTerminal = fromTerminal;
        this.searchTitle = searchTitle;
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

    public String getSearchTitle() {
        return searchTitle;
    }

    public void setSearchTitle(String searchTitle) {
        this.searchTitle = searchTitle;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SearchLog{" +
                "id=" + id +
                ", uId='" + uId + '\'' +
                ", fromTerminal=" + fromTerminal +
                ", searchTitle='" + searchTitle + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
