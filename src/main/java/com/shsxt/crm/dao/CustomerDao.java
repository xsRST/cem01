package com.shsxt.crm.dao;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.vo.Customer;

/**
 * @author 殇丶无求
 */
public interface CustomerDao extends BaseDao<Customer> {

    /**
     * 通过客户名字获取记录
     * @param name
     * @return
     */
    Customer selectByNmae(String name);
}
