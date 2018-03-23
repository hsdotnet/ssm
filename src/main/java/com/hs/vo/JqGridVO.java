package com.hs.vo;

import java.util.List;

public class JqGridVO<T> {
    private List<T> rows;     //记录

    public List<T> getRows() {
        return rows;
    }

    public JqGridVO(List<T> rows) {
        this.rows = rows;
    }
}
