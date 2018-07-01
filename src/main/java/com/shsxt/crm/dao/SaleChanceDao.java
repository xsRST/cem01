package com.shsxt.crm.dao;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.vo.SaleChance;
import org.apache.ibatis.annotations.Param;

/**
 * @author 殇丶无求
 */
public interface SaleChanceDao extends BaseDao<SaleChance> {



    /**
     * 更改客户开发状态
     * @param saleChanceId
     * @param devResult
     * @return
     */
    int updateDevResult(@Param(value = "saleChanceId") Integer saleChanceId, @Param(value = "devResult") Integer devResult);
}