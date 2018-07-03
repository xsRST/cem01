package com.shsxt.crm.service;

import com.github.pagehelper.PageInfo;
import com.shsxt.base.BaseService;
import com.shsxt.crm.dao.OrderDao;
import com.shsxt.crm.query.OrderQuery;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.vo.Order;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 殇丶无求
 */
@Service
public class OrderService extends BaseService<Order> {

    @Resource
    private OrderDao orderDao;

    /**
     * 根据id查询订单详情
     * @param id
     * @return
     */
    public Order queryOrderById(Integer id) {
        return orderDao.selectById(id);
    }
    /**
     * 查询客户订单记录
     * @param orderQuery
     * @return
     */
    public Map<String,Object> queryByParams(OrderQuery orderQuery) {
        Map<String,Object> map=new HashMap<>(6);
        PageInfo<Order> pageInfo=queryForPage(orderQuery);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }


    /**
     * 检验参数
     * @param id
     * @param cusId
     * @param orderDate
     * @param address
     * @param state
     */
    private void checkCustomerParams(Integer id, Integer cusId, Date orderDate, String address, Integer state) {
        AssertUtil.isTrue(null==id,"请选择订单");
        checkCustomerParams(cusId, orderDate, address, state);
    }

    private void checkCustomerParams(Integer cusId, Date orderDate, String address, Integer state) {

        AssertUtil.isTrue(null==cusId,"请选择客户");
        AssertUtil.isTrue(null==orderDate,"请输入订单日期");
        AssertUtil.isTrue(StringUtils.isBlank(address),"请输入交往地址");
        AssertUtil.isTrue(null==state,"请输入订单状态,未付款/已回款");
    }


}
