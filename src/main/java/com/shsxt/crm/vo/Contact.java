package com.shsxt.crm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shsxt.base.BaseModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 交往记录
 *
 * @author 殇丶无求
 */
public class Contact  extends BaseModel {

    /**客户ID**/
    private Integer cusId;
    /**交往时间**/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date contactTime;
    /**交往地址**/
    private String address;
    /**概要**/
    private String overview;

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Date getContactTime() {
        return contactTime;
    }

    public void setContactTime(Date contactTime) {
        this.contactTime = contactTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
