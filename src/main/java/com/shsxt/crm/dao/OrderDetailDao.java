package com.shsxt.crm.dao;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.query.OrderDetailQuery;
import com.shsxt.crm.vo.OrderDetail;

import java.util.List;

/**
 * @author 殇丶无求
 */
public interface OrderDetailDao extends BaseDao<OrderDetail> {

    /**
     * 条件查询订单详情,主要是通过订单ID
     * @param orderDetailQuery
     * @return
     */
    List<OrderDetail> queryByParams(OrderDetailQuery orderDetailQuery);

    /**
     * 通过订单ID 查询总金额
     * @param orderId
     * @return
     */
    Float getTotalPrice(Integer orderId);
}
