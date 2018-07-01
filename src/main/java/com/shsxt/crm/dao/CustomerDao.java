package com.shsxt.crm.dao;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.vo.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

/**
 * @author 殇丶无求
 */
public interface CustomerDao extends BaseDao<Customer> {

    /**
     * 通过客户名字获取记录
     * @param name
     * @return
     * @throws DataAccessException
     */
    Customer selectByNmae(String name)throws DataAccessException;

    /**
     * 删除
     * @param ids
     * @return
     * @throws DataAccessException
     */
    Integer delete(@Param(value = "ids") String ids) throws DataAccessException;
}
