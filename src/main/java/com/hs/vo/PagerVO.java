package com.hs.vo;

public class PagerVO {
    private int page;
    private int rows;
    private String sidx;
    private String sord;
    private int offset;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public int getOffset() {
        return (page - 1) * rows;
    }

    @Override
    public String toString() {
        return "PagerVO{" +
                "page=" + page +
                ", rows=" + rows +
                ", sidx='" + sidx + '\'' +
                ", sord='" + sord + '\'' +
                ", offset=" + offset +
                '}';
    }
}