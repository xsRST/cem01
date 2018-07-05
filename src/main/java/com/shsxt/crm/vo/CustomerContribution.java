package com.shsxt.crm.vo;

import java.io.Serializable;

/**
 * 客户构成分析
 * @author 殇丶无求
 */
public class CustomerContribution implements Serializable {

    private Integer id;
    private String name;
    private Integer amount;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
