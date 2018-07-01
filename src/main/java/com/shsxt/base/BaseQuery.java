package com.shsxt.base;

/**
 * @author 殇丶无求
 */
public class BaseQuery {
    /**当前页码**/
    private Integer page=1;
    /**每页显示数量**/
    private Integer rows=10;

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
