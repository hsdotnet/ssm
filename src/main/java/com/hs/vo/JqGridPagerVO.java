package com.hs.vo;

import java.util.List;

public class JqGridPagerVO<T> extends JqGridVO<T> {
    private int records;    //总记录数
    private int page;       //当前页
    private int total;     //总页数

    public int getRecords() {
        return records;
    }

    public int getPage() {
        return page;
    }

    public int getTotal() {
        return total;
    }

    public JqGridPagerVO(List<T> rows, int records, int page, int total) {
        super(rows);
        this.records = records;
        this.page = page;
        this.total = total;
    }
}
