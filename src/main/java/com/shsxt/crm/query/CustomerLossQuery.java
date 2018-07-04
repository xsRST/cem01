package com.shsxt.crm.query;

import com.shsxt.base.BaseQuery;

/**
 * 客户流失
 * @author 殇丶无求
 */
public class CustomerLossQuery extends BaseQuery {

    private String cusName;
    private String cusManager;
    /**状态 0:暂缓,1确认流失**/
    private Integer state;

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusManager() {
        return cusManager;
    }

    public void setCusManager(String cusManager) {
        this.cusManager = cusManager;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
