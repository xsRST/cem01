package com.shsxt.crm.vo;

import com.shsxt.base.BaseModel;

/**
 * 订单详情
 * @author 殇丶无求
 */
public class OrderDetail extends BaseModel {
    /**订单ID**/
    private Integer orderId;
    /**物品名称**/
    private String goodsName;
    /**物品数量**/
    private Integer goodsNum;
    /**物品单位**/
    private String unit;
    /**物品价格**/
    private Float price;
    /**总价格**/
    private Float sum;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
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

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }
}
