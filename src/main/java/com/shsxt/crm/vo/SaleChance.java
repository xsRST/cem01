package com.shsxt.crm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shsxt.base.BaseModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 销售机会
 * @author 殇丶无求
 */
public class SaleChance extends BaseModel {

    /**机会来源**/
    private String chanceSource;

    /**客户名称**/
    private String customerName;

    /**成功几率**/
    private Integer cgjl;

    /**概要**/
    private String overview;

    /**联系人**/
    private String linkMan;

    /**联系电话**/
    private String linkPhone;

    /**机会描述**/
    private String description;

    /**创建人**/
    private String createMan;

    /**分配人ID**/
    private Integer assignId;
    /**分配人名称**/
    private String assignMan;

    /**分配时间**/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT"+8)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date assignTime;

    /**分配状态**/
    private Integer state;

    /**开发状态**/
    private Integer devResult;

    public String getAssignMan() {
        return assignMan;
    }

    public void setAssignMan(String assignMan) {
        this.assignMan = assignMan;
    }


    public String getChanceSource() {
        return chanceSource;
    }

    public void setChanceSource(String chanceSource) {
        this.chanceSource = chanceSource == null ? null : chanceSource.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public Integer getCgjl() {
        return cgjl;
    }

    public void setCgjl(Integer cgjl) {
        this.cgjl = cgjl;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview == null ? null : overview.trim();
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone == null ? null : linkPhone.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCreateMan() {
        return createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan == null ? null : createMan.trim();
    }

    public Integer getAssignId() {
        return assignId;
    }

    public void setAssignId(Integer assignId) {
        this.assignId = assignId;
    }

    public Date getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(Date assignTime) {
        this.assignTime = assignTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDevResult() {
        return devResult;
    }

    public void setDevResult(Integer devResult) {
        this.devResult = devResult;
    }

}