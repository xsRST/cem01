package com.shsxt.crm.vo;

import com.shsxt.base.BaseModel;

import java.util.Date;

/**
 * 客户流失数据对象
 * @author 殇丶无求
 */
public class CustomerLoss extends BaseModel {
    /**客户名称**/
    private String cusName;
    /**客户编号**/
    private String cusNo;
    /**客户经理**/
    private String cusManager;
    /**状态**/
    private Integer state;
    /**最后一次下单日期**/
    private Date lastOrderTime;
    /**确认流失日期**/
    private Date confirmLossTime;
    /**流失原因**/
    private String lossReason;

    public String getCusNo() {
        return cusNo;
    }

    public void setCusNo(String cusNo) {
        this.cusNo = cusNo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getLossReason() {
        return lossReason;
    }

    public void setLossReason(String lossReason) {
        this.lossReason = lossReason;
    }

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

    public Date getLastOrderTime() {
        return lastOrderTime;
    }

    public void setLastOrderTime(Date lastOrderTime) {
        this.lastOrderTime = lastOrderTime;
    }

    public Date getConfirmLossTime() {
        return confirmLossTime;
    }

    public void setConfirmLossTime(Date confirmLossTime) {
        this.confirmLossTime = confirmLossTime;
    }
}
