package com.shsxt.crm.service;

import com.shsxt.base.BaseService;
import com.shsxt.crm.dao.CusDevPlanDao;
import com.shsxt.crm.dao.SaleChanceDao;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.vo.CusDevPlan;
import com.shsxt.crm.vo.SaleChance;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CusDevPlanService extends BaseService<CusDevPlan>{

    @Autowired
    private CusDevPlanDao cusDevPlanDao;

    @Autowired
    private SaleChanceDao saleChanceDao;


    /**
     * 显示当前客户的计划
     * @param saleChanceId
     * @return
     */
    public List<CusDevPlan> queryBySaleChanceId(Integer saleChanceId) {
        AssertUtil.isTrue(null ==saleChanceId||saleChanceId==0 ,"请选择营销机会");
        return cusDevPlanDao.queryBySaleChanceId(saleChanceId);
    }

    /**
     * 添加计划
     * @param saleChanceId
     * @param cusDevPlan
     */
    public void addPlan(Integer saleChanceId, CusDevPlan cusDevPlan) {
        /*
            1.判断参数:客户ID,计划日期,计划内容
            2.执行操作
         */
        checkParams(saleChanceId,cusDevPlan.getPlanItem(),cusDevPlan.getExeAffect(),cusDevPlan.getPlanDate());
        /*
            封装到实体类:创建时间,更新时间,判断赋值,有效
         */
        cusDevPlan.setSaleChanceId(saleChanceId);
        cusDevPlan.setCreateDate(new Date());
        cusDevPlan.setUpdateDate(new Date());
        cusDevPlan.setIsValid(1);
        AssertUtil.isTrue(cusDevPlanDao.insert(cusDevPlan)<1,"添加失败");
        /*
            添加成功之后 更新客户开发状态
         */
        SaleChance saleChance =saleChanceDao.selectById(saleChanceId);
        if(saleChance.getState()==0){
            saleChance.setState(1);
            AssertUtil.isTrue(saleChanceDao.update(saleChance)<1,"添加失败");
        }
    }
    /**
     * 删除客户计划
     * @param saleChanceId
     * @param id
     */
    public void deletePlan(Integer saleChanceId, Integer id) {
        AssertUtil.isTrue(null==saleChanceId,"请选择客户");
        AssertUtil.isTrue(null==id,"请选择删除计划");
        CusDevPlan cusDevPlan=new CusDevPlan();
        cusDevPlan.setId(id);
        cusDevPlan.setIsValid(0);
        AssertUtil.isTrue(cusDevPlanDao.update(cusDevPlan)<1,"删除失败");
    }

    /**
     * 更新计划
     * @param cusDevPlan
     */
    public void updatePlan(Integer saleChanceId,CusDevPlan cusDevPlan) {
        /*
            1.判断参数
            2.设置参数:客户ID,更新时间,
         */
        checkParams(cusDevPlan.getId(),saleChanceId,cusDevPlan.getPlanItem(),cusDevPlan.getExeAffect(),cusDevPlan.getPlanDate());
        cusDevPlan.setSaleChanceId(saleChanceId);
        cusDevPlan.setIsValid(1);
        AssertUtil.isTrue(cusDevPlanDao.update(cusDevPlan)<1,"更新失败");
        /*
            更新完计划之后 要
         */
    }

    /**
     * 检验参数
     * @param id
     * @param saleChanceId
     * @param planItem
     * @param planDate
     */
    private void checkParams(Integer id, Integer saleChanceId, String planItem,String exeAffect, Date planDate) {
        checkParams(saleChanceId,planItem,exeAffect,planDate);
        AssertUtil.isTrue(null==id,"请选择计划");
    }

    /**
     * 检验参数
     * @param saleChanceId
     * @param planItem
     * @param planDate
     */
    private void checkParams(Integer saleChanceId, String planItem,String exeAffect, Date planDate) {
        AssertUtil.isTrue(null==saleChanceId||saleChanceId==0,"请选择客户");
        AssertUtil.isTrue(null==planDate,"请输入计划日期");
        AssertUtil.isTrue(StringUtils.isBlank(planItem),"请输入计划内容");
        AssertUtil.isTrue(StringUtils.isBlank(exeAffect),"请输入计划结果");
    }


}
