package com.shsxt.crm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shsxt.base.BaseModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 客户发展计划
 * @author 殇丶无求
 */
public class CusDevPlan extends BaseModel {

    /**销售机会ID**/
    private Integer saleChanceId;

    /**计划内容**/
    private String planItem;

    /**计划日期**/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT"+8)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date planDate;

    /**计划结果**/
    private String exeAffect;

    public Integer getSaleChanceId() {
        return saleChanceId;
    }

    public void setSaleChanceId(Integer saleChanceId) {
        this.saleChanceId = saleChanceId;
    }

    public String getPlanItem() {
        return planItem;
    }

    public void setPlanItem(String planItem) {
        this.planItem = planItem == null ? null : planItem.trim();
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public String getExeAffect() {
        return exeAffect;
    }

    public void setExeAffect(String exeAffect) {
        this.exeAffect = exeAffect == null ? null : exeAffect.trim();
    }

}