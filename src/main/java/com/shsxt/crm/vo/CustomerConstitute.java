package com.shsxt.crm.vo;

import java.io.Serializable;

/**
 * 客户构成分析
 * @author 殇丶无求
 */
public class CustomerConstitute implements Serializable {

    private String level;
    private Integer amount;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
