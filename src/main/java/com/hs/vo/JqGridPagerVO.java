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

    /**
     * @param rows     记录
     * @param records  总记录数
     * @param page     当前页
     * @param pagesize 页大小
     */
    public JqGridPagerVO(List<T> rows, int records, int page, int pagesize) {
        super(rows);
        this.records = records;
        this.page = page;
        this.total = (records + pagesize - 1) / pagesize;
    }

    /**
     *
     * @param rows
     * @param records
     * @param page
     */
    public JqGridPagerVO(List<T> rows, int records, PageVO page) {
        super(rows);
        this.records = records;
        this.page = page.getPage();
        this.total = (records + page.getRows() - 1) / page.getRows();
    }
}