package com.shsxt.crm.vo;

import com.shsxt.base.BaseModel;

/**
 * @author 殇丶无求
 */
public class Linkman extends BaseModel {

    /**客户ID**/
    private Integer cusId;
    /**联系人**/
    private String linkName;
    /**性别**/
    private String sex;
    /**职位**/
    private String zhiwei;
    /**办公电话**/
    private String officePhone;
    /**手机号**/
    private String phone;

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getZhiwei() {
        return zhiwei;
    }

    public void setZhiwei(String zhiwei) {
        this.zhiwei = zhiwei;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
