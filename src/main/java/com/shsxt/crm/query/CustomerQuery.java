package com.shsxt.crm.query;

import com.shsxt.base.BaseQuery;

/**
 * @author 殇丶无求 
 */
public class CustomerQuery extends BaseQuery {

    /**
     * 客户编号
     */
    private String khno;
    /**
     * 客户名称
     */
    private String name;

    public String getKhno() {
        return khno;
    }

    public void setKhno(String khno) {
        this.khno = khno==null?null:khno.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name== null ? null : name.trim();
    }
}
