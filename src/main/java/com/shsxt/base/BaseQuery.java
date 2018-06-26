package com.shsxt.base;

public class BaseQuery {
    private Integer pageNum=1; //当前页码
    private Integer pageSize=10; //每页显示数量

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
