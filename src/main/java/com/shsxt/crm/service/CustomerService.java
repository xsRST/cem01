package com.shsxt.crm.service;

import com.github.pagehelper.PageInfo;
import com.shsxt.base.BaseService;
import com.shsxt.crm.dao.CustomerDao;
import com.shsxt.crm.query.CustomerQuery;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.vo.Customer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerService extends BaseService<Customer> {

    @Resource
    private CustomerDao customerDao;

    /**
     * 查询客户列表
     * @param customerQuery
     * @return
     */
    public Map<String,Object> queryByParams(CustomerQuery customerQuery) {
        Map<String,Object> map=new HashMap<>();
        PageInfo<Customer> pageInfo=queryForPage(customerQuery);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    /**
     * 更新客户
     * @param customer
     */
    public void updateCustomer(Customer customer) {
        /*
            1基本参数校验:id,客户名称,地区,满意度,信用度,邮政编码,联系电话,传真,网址,
                客户地址,法人,年营业额(万元),开户银行,开户账号,
             客户名称唯一性
               设置其他参数:
                    是否有效
                    更新时间
            2.执行方法
         */
        checkCustomerParams(customer.getId(),customer.getName(),customer.getArea(),customer.getMyd(),customer.getXyd(),customer.getPostCode(),
                customer.getPhone(),customer.getFax(), customer.getWebSite(),customer.getAddress(),customer.getFr(),
                customer.getNyye(),customer.getKhyh(),customer.getKhzh());
        customer.setUpdateDate(new Date());
        customer.setIsValid(1);
        AssertUtil.isTrue(customerDao.insert(customer)<1,"更新失败");
    }

    /**
     * 检验参数
     */
    private void checkCustomerParams(Integer id,String name, String area, String myd, String xyd, String postCode, String phone,
                                     String fax, String webSite, String address, String fr, String nyye, String khyh,
                                     String khzh){
        AssertUtil.isTrue(null==id,"请选择客户");
        checkCustomerParams(name, area, myd, xyd, postCode, phone, fax, webSite, address, fr, nyye, khyh, khzh);
    }
    /**
     * 检验参数
     */
    private void checkCustomerParams(String name, String area, String myd, String xyd, String postCode, String phone,
                                     String fax, String webSite, String address, String fr, String nyye, String khyh,
                                     String khzh) {
        AssertUtil.isTrue(StringUtils.isBlank(name),"客户名称不可为空");
        AssertUtil.isTrue(StringUtils.isBlank(area),"请选择地区");
        AssertUtil.isTrue(StringUtils.isBlank(myd),"请选择满意度");
        AssertUtil.isTrue(StringUtils.isBlank(xyd),"请选择信用度");
        AssertUtil.isTrue(StringUtils.isBlank(postCode),"请输入邮政编码");
        AssertUtil.isTrue(StringUtils.isBlank(phone),"请输入手机号");
        AssertUtil.isTrue(StringUtils.isBlank(fax),"请输入传真");
        AssertUtil.isTrue(StringUtils.isBlank(webSite),"请输入网址");
        AssertUtil.isTrue(StringUtils.isBlank(address),"请输入详细地址");
        AssertUtil.isTrue(StringUtils.isBlank(fr),"请输入法人");
        AssertUtil.isTrue(StringUtils.isBlank(nyye),"输入年营业额");
        AssertUtil.isTrue(StringUtils.isBlank(khyh),"请输入开户银行");
        AssertUtil.isTrue(StringUtils.isBlank(khzh),"请输入开户账号");
    }
}
