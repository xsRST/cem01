package com.shsxt.crm.controller;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.query.OrderQuery;
import com.shsxt.crm.service.OrderService;
import com.shsxt.crm.service.CustomerService;
import com.shsxt.crm.vo.Order;
import com.shsxt.crm.vo.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 殇丶无求
 */
@RequestMapping("order")
@Controller
public class OrderController extends BaseController<Order> {

    @Resource
    private OrderService orderService;
    @Resource
    private CustomerService customerService;


    @RequestMapping("queryOrderById")
    @ResponseBody
    public Order queryOrderById(Integer id){
        return orderService.queryOrderById(id);
    }

    /**
     * 根据用户ID查询订单列表
     * @param orderQuery
     * @param cusId
     * @return
     */
    @RequestMapping("{cusId}/list_order")
    @ResponseBody
    public Map<String,Object> queryByParams(@PathVariable Integer cusId, OrderQuery orderQuery){
        orderQuery.setCusId(cusId);
        return orderService.queryByParams(orderQuery);
    }

    /**
     * 跳转到联系人管理页面
     * @return
     */
    @RequestMapping("{customerId}/index")
    public String index(@PathVariable Integer customerId, HttpServletRequest request){
        Customer customer=customerService.selectById(customerId);
        request.setAttribute("customer",customer);
        return "customer_order";
    }
}
