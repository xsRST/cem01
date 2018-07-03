package com.shsxt.crm.controller;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.query.ContactQuery;
import com.shsxt.crm.service.CustomerService;
import com.shsxt.crm.service.ContactService;
import com.shsxt.crm.vo.Customer;
import com.shsxt.crm.vo.Contact;
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
@RequestMapping("contact")
@Controller
public class ContactController extends BaseController<Contact> {

    @Resource
    private ContactService contactService;
    @Resource
    private CustomerService customerService;

    /**
     * 删除客户联系人
     * @param cusId
     * @return
     */
    @RequestMapping("{cusId}/delete")
    @ResponseBody
    public ResultInfo<Contact> delete(@PathVariable Integer cusId,Contact contact){
        contactService.deleteContact(contact.getId());
        return success("删除成功");
    }
    /**
     * 添加客户联系人
     * @param contact
     * @return
     */
    @RequestMapping("{cusId}/add")
    @ResponseBody
    public Contact add(@PathVariable Integer cusId,Contact contact){
        contactService.addContact(contact);
        return contact;
    }
    /**
     * 更新客户
     * @param contact
     * @return
     */
    @RequestMapping("{cusId}/update")
    @ResponseBody
    public ResultInfo<Contact> update(@PathVariable Integer cusId, Contact contact){
        contactService.updateContact(contact);
        return success("更新成功");
    }

    /**
     * 根据用户ID查询联系人列表
     * @param contactQuery
     * @param cusId
     * @return
     */
    @RequestMapping("{cusId}/list_contact")
    @ResponseBody
    public Map<String,Object> queryByParams(@PathVariable Integer cusId, ContactQuery contactQuery){
        contactQuery.setCusId(cusId);
        return contactService.queryByParams(contactQuery);
    }

    /**
     * 跳转到联系人管理页面
     * @return
     */
    @RequestMapping("{customerId}/index")
    public String index(@PathVariable Integer customerId, HttpServletRequest request){
        Customer customer=customerService.selectById(customerId);
        request.setAttribute("customer",customer);
        return "contact";
    }
}
