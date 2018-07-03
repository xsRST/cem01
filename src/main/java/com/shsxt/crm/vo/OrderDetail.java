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
    private Integer unit;
    /**物品价格**/
    private Integer price;
    /**总价格**/
    private Integer sum;

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

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
}
