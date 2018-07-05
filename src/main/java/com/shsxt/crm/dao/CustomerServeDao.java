package com.shsxt.crm.dao;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.vo.CustomerServe;
import com.shsxt.crm.vo.CustomerServeAnalysis;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * 客户服务
 * @author 殇丶无求
 */
public interface CustomerServeDao extends BaseDao<CustomerServe> {


    /**
     * 客户服务分析
     * @return
     * @throws DataAccessException
     */
    @Select("SELECT SERVE_TYPE,COUNT(*) AS amount FROM T_CUSTOMER_SERVE WHERE IS_VALID=1 GROUP BY SERVE_TYPE")
    List<CustomerServeAnalysis> findServeAnalysis() throws DataAccessException;
}
