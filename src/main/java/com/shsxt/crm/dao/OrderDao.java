package com.shsxt.crm.dao;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.query.OrderQuery;
import com.shsxt.crm.vo.Order;

import java.util.List;

/**
 * @author 殇丶无求
 */
public interface OrderDao extends BaseDao<Order> {

    /**
     * 通过客户Id和联系人名称,手机号,性别获取获取记录
     * @param orderQuery
     * @return
     */
    List<Order> queryByParams(OrderQuery orderQuery);

    /**
     * 删除单个客户联系人
     * @param cusId
     * @return
     */
    Integer delete(Integer cusId);
}
