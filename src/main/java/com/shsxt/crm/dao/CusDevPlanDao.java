package com.shsxt.crm.dao;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.vo.CusDevPlan;

import java.util.List;

public interface CusDevPlanDao extends BaseDao<CusDevPlan> {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(CusDevPlan record);

    CusDevPlan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CusDevPlan record);

    int updateByPrimaryKey(CusDevPlan record);

    List<CusDevPlan> queryBySaleChanceId(Integer saleChanceId);
}