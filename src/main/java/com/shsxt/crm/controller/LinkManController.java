package com.shsxt.crm.controller;

import com.shsxt.base.BaseController;
import com.shsxt.crm.query.LinkmanQuery;
import com.shsxt.crm.service.CustomerService;
import com.shsxt.crm.service.LinkmanService;
import com.shsxt.crm.vo.Customer;
import com.shsxt.crm.vo.Linkman;
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
@RequestMapping("linkman")
@Controller
public class LinkManController extends BaseController<Linkman> {

    @Resource
    private LinkmanService linkmanService;
    @Resource
    private CustomerService customerService;


    /**
     * 根据用户ID查询联系人列表
     * @param linkmanQuery
     * @param cusId
     * @return
     */
    @RequestMapping("{cusId}/list_linkman")
    @ResponseBody
    public Map<String,Object> queryByParams(@PathVariable Integer cusId, LinkmanQuery linkmanQuery){
        linkmanQuery.setCusId(cusId);
        return linkmanService.queryByParams(linkmanQuery);
    }

    /**
     * 跳转到联系人管理页面
     * @return
     */
    @RequestMapping("{customerId}/index")
    public String index(@PathVariable Integer customerId, HttpServletRequest request){
        Customer customer=customerService.selectById(customerId);
        request.setAttribute("customer",customer);
        return "linkman";
    }
}
