package com.shsxt.crm.dao;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.vo.CusDevPlan;

import java.util.List;

/**
 * @author 殇丶无求
 */
public interface CusDevPlanDao extends BaseDao<CusDevPlan> {

    /**
     * 通过销售机会ID查询对应计划
     * @param saleChanceId
     * @return
     */
    List<CusDevPlan> queryBySaleChanceId(Integer saleChanceId);
}