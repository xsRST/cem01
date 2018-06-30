package com.shsxt.base;

public class BaseQuery {
    private Integer page=1; //当前页码
    private Integer rows=10; //每页显示数量

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
