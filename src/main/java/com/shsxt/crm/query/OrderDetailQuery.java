package com.shsxt.crm.query;

import com.shsxt.base.BaseQuery;

/**
 *
 * @author 殇丶无求 
 */
public class OrderDetailQuery extends BaseQuery {
    /**订单ID**/
    private Integer orderId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
