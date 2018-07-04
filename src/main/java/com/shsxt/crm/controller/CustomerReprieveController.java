package com.shsxt.crm.controller;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.query.CustomerReprieveQuery;
import com.shsxt.crm.service.CustomerLossService;
import com.shsxt.crm.service.CustomerReprieveService;
import com.shsxt.crm.vo.CustomerLoss;
import com.shsxt.crm.vo.CustomerReprieve;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 客户流失暂缓措施
 * @author 殇丶无求
 */
@Controller
@RequestMapping("customer_reprieve")
public class CustomerReprieveController extends BaseController<CustomerReprieve> {
    @Resource
    private CustomerReprieveService customerReprieveService;
    @Resource
    private CustomerLossService customerLossService;


    /**
     * 根据流失客户跳转到相应的客户流失管理页面
     * @param lossId
     * @return
     */
    @RequestMapping("index")
    public String index(@RequestParam(value = "lossId") Integer lossId, HttpServletRequest request){
        CustomerLoss customerLoss=customerLossService.selectById(lossId);
        request.setAttribute("customerLoss",customerLoss);
        return "customer_reprieve";
    }

    /**
     * 根据流失ID,查询相应措施
     * @param customerReprieveQuery
     * @return
     */
    @RequestMapping("customerReprievesByLossId")
    @ResponseBody
    public Map<String,Object> customerReprievesByLossId(@RequestParam(value = "lossId") Integer lossId, CustomerReprieveQuery customerReprieveQuery){
        return customerReprieveService.selectByLossId(customerReprieveQuery);
    }


    /**
     * 增加客户流失措施
     * @param customerReprieve
     * @return
     */
    @RequestMapping("insert")
    @ResponseBody
    public CustomerReprieve insert(CustomerReprieve customerReprieve){
        customerReprieveService.insert(customerReprieve);
        return customerReprieve;
    }

    /**
     * 更新客户流失措施
     * @param customerReprieve
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public ResultInfo<CustomerReprieve> update(CustomerReprieve customerReprieve){
        customerReprieveService.update(customerReprieve);
        return success("更新成功");
    }
    /**
     * 删除客户流失措施
     * @param id
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo<CustomerReprieve> delete(@RequestParam(value = "id") Integer id){
        customerReprieveService.delete(id);
        return success("删除成功");
    }
}
