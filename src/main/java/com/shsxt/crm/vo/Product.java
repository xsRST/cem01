package com.shsxt.crm.vo;

import com.shsxt.base.BaseModel;

/**
 * 字典
 * @author 殇丶无求
 */
public class Product extends BaseModel {

    /**产品名称**/
    private String productName;
    /**型号**/
    private String model;
    /**单位**/
    private String unit;
    /**价格**/
    private Float price;
    /**库存**/
    private String store;
    /**备注**/
    private String remark;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
