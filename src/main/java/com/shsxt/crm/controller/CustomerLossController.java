package com.shsxt.crm.controller;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.query.CustomerLossQuery;
import com.shsxt.crm.service.CustomerLossService;
import com.shsxt.crm.vo.CustomerLoss;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 殇丶无求
 */
@Controller
@RequestMapping("customer_loss")
public class CustomerLossController extends BaseController<CustomerLoss> {

    @Resource
    private CustomerLossService customerLossService;

    /**
     * 根据条件查询客户流失列表
     * @param customerLossQuery
     * @return
     */
    @RequestMapping("queryCustomerLossesByParams")
    @ResponseBody
    public Map<String,Object> queryCustomerLossesByParams(CustomerLossQuery customerLossQuery){
        return customerLossService.queryCustomerLossesByParams(customerLossQuery);
    }
    /**
     * 转到客户流失页面
     * @param request
     * @return
     */
    @RequestMapping("index")
    public String index(HttpServletRequest request){
        return "customer_loss";
    }


    /**
     * 更新客户流失状态
     * @return
     */
    @RequestMapping("updateCustomerLossState")
    @ResponseBody
    public ResultInfo<CustomerLoss> updateCustomerLossState(CustomerLoss customerLoss){
        customerLossService.updateCustomerLossState(customerLoss);
        return success("更新状态成功");
    }
}
