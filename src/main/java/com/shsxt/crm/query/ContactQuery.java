package com.shsxt.crm.query;

import com.shsxt.base.BaseQuery;

/**
 * @author 殇丶无求 
 */
public class ContactQuery extends BaseQuery {
    /**客户ID**/
    private Integer cusId;

    /**联系人名称**/
    private String linkName;

    /**联系人性别**/
    private String sex;

    /**联系人手机号**/
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
