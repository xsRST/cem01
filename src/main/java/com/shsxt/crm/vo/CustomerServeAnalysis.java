package com.shsxt.crm.vo;

import java.io.Serializable;

/**
 * 客户服务分析
 * @author 殇丶无求
 */
public class CustomerServeAnalysis implements Serializable {

    private String serveType;
    private Integer amount;

    public String getServeType() {
        return serveType;
    }

    public void setServeType(String serveType) {
        this.serveType = serveType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
