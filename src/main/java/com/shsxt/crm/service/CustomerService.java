package com.shsxt.crm.service;

import com.github.pagehelper.PageInfo;
import com.shsxt.base.BaseService;
import com.shsxt.crm.dao.CustomerDao;
import com.shsxt.crm.query.CustomerQuery;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.vo.Customer;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 殇丶无求
 */
@Service
public class CustomerService extends BaseService<Customer> {

    @Resource
    private CustomerDao customerDao;

    /**
     * 删除客户
     * @param ids
     */
    public void deleteCustomer(String ids) {
        Integer len=ids.length();
        System.out.println(len);
        AssertUtil.isTrue(StringUtils.isBlank(ids)||customerDao.delete(ids)<1,"删除失败");
    }
    /**
     * 查询客户列表
     * @param customerQuery
     * @return
     */
    public Map<String,Object> queryByParams(CustomerQuery customerQuery) {
        Map<String,Object> map=new HashMap<>(6);
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

        AssertUtil.isTrue(customerDao.update(customer)<1,"更新失败");
    }

    /**
     * 添加客户
     * @param customer
     */
    public void addCustomer(Customer customer) {
        //基本参数校验
        checkCustomerParams(customer.getName(),customer.getArea(),customer.getMyd(),customer.getXyd(),customer.getPostCode(),
                customer.getPhone(),customer.getFax(), customer.getWebSite(),customer.getAddress(),customer.getFr(),
                customer.getNyye(),customer.getKhyh(),customer.getKhzh());
        //检验客户名称唯一性
        Customer customerDb=customerDao.selectByNmae(customer.getName());
        //若客户名称存在
        if(null!=customerDb){
            //若客户是无效客户,执行更新操作
            //TODO 若客户是无效客户,执行更新操作
            if(customerDb.getIsValid()==0){
                customer.setId(customerDb.getId());
                customerDb=customer;
                customerDb.setUpdateDate(new Date());
                //调用更新方法
                updateCustomer(customerDb);
                return;
            }
            AssertUtil.isTrue(customerDb.getIsValid()==1,"客户名称已存在");
        }
        //参数设置
        String now = DateFormatUtils.format(new Date(),"yyyyMMdd");
        Integer random=RandomUtils.nextInt(100,999);
        String khno="KH"+now+random;
        //客户编号
        customer.setKhno(khno);
        //客户有效
        customer.setIsValid(1);
        customer.setState(0);
        //客户创建时间
        customer.setCreateDate(new Date());
        //客户更新时间
        customer.setUpdateDate(new Date());
        //保存数据
        AssertUtil.isTrue(customerDao.insert(customer)<1,"添加失败");
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
