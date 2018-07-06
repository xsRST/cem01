package com.shsxt.crm.controller;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.query.OrderDetailQuery;
import com.shsxt.crm.service.OrderDetailService;
import com.shsxt.crm.vo.OrderDetail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author 殇丶无求
 */
@RequestMapping("orderDetail")
@Controller
public class OrderDetailController extends BaseController<OrderDetail> {

    @Resource
    private OrderDetailService orderDetailService;

    @RequestMapping("getTotalPrice")
    @ResponseBody
    public ResultInfo getTotalPrice(Integer orderId){
        Float total=orderDetailService.getTotalPrice(orderId);
        return  success(total);
    }

    /***
     * 根据id获取记录
     * @param id
     * @return
     */
    @RequestMapping("orderId}/queryOrderDetailById")
    @ResponseBody
    public OrderDetail queryOrderDetailById(Integer id){
        return orderDetailService.queryOrderDetailById(id);
    }

    /**
     * 根据订单ID查询订单列表
     * @param orderDetailQuery
     * @return
     */
    @RequestMapping("queryOrderDetailsByOrderId")
    @ResponseBody
    public Map<String,Object> queryByParams(OrderDetailQuery orderDetailQuery){
        return orderDetailService.queryByParams(orderDetailQuery);
    }

}
