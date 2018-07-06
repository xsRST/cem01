package com.shsxt.crm.service;

import com.github.pagehelper.PageInfo;
import com.shsxt.base.BaseService;
import com.shsxt.crm.dao.OrderDetailDao;
import com.shsxt.crm.query.OrderDetailQuery;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.vo.OrderDetail;
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
public class OrderDetailService extends BaseService<OrderDetail> {

    @Resource
    private OrderDetailDao orderDetailDao;

    /**
     * 根据订单ID获取总金额
     * @param orderId
     * @return
     */
    public Float getTotalPrice(Integer orderId) {
        AssertUtil.isTrue(null==orderId,"请选择订单");
        return orderDetailDao.getTotalPrice(orderId);
    }
    /**
     * 根据id查询订单详情
     * @param id
     * @return
     */
    public OrderDetail queryOrderDetailById(Integer id) {
        return orderDetailDao.selectById(id);
    }
    /**
     * 查询客户订单记录
     * @param orderDetailQuery
     * @return
     */
    public Map<String,Object> queryByParams(OrderDetailQuery orderDetailQuery) {
        Map<String,Object> map=new HashMap<>(6);
        PageInfo<OrderDetail> pageInfo=queryForPage(orderDetailQuery);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }


    /**
     * 检验参数
     * @param id
     * @param cusId
     * @param orderDetailDate
     * @param address
     * @param state
     */
    private void checkCustomerParams(Integer id, Integer cusId, Date orderDetailDate, String address, Integer state) {
        AssertUtil.isTrue(null==id,"请选择订单");
        checkCustomerParams(cusId, orderDetailDate, address, state);
    }

    private void checkCustomerParams(Integer cusId, Date orderDetailDate, String address, Integer state) {

        AssertUtil.isTrue(null==cusId,"请选择客户");
        AssertUtil.isTrue(null==orderDetailDate,"请输入订单日期");
        AssertUtil.isTrue(StringUtils.isBlank(address),"请输入交往地址");
        AssertUtil.isTrue(null==state,"请输入订单状态,未付款/已回款");
    }



}
