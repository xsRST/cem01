package com.shsxt.crm.query;

import com.shsxt.base.BaseQuery;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 服雾查询条件
 * @author 殇丶无求
 */
public class CustomerServeQuery extends BaseQuery {

    /**服务类型**/
    private String serveType;
    /**概要**/
    private String overview;
    /**状态**/
    private Integer state;
    /**客户名称**/
    private String customer;
    /**开始创建时间**/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDateFrom;
    /**结束创建时间**/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDateTo;

    public String getServeType() {
        return serveType;
    }

    public void setServeType(String serveType) {
        this.serveType = serveType;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer.trim();
    }

    public Date getCreateDateFrom() {
        return createDateFrom;
    }

    public void setCreateDateFrom(Date createDateFrom) {
        this.createDateFrom = createDateFrom;
    }

    public Date getCreateDateTo() {
        return createDateTo;
    }

    public void setCreateDateTo(Date createDateTo) {
        this.createDateTo = createDateTo;
    }
}
