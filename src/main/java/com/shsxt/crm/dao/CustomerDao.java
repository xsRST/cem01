package com.shsxt.crm.dao;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.vo.Customer;
import com.shsxt.crm.vo.CustomerConstitute;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import java.util.List;

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

    /**
     * 统计客户构成,客户等级,客户数量
     * @return
     * @throws DataAccessException
     */
    @Select("SELECT COUNT(*) AS AMOUNT,`LEVEL`  FROM T_CUSTOMER WHERE IS_VALID=1 GROUP BY `LEVEL`")
    List<CustomerConstitute> findConstitute()throws DataAccessException;
}
