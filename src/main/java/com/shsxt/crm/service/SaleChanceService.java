package com.shsxt.crm.service;

import com.github.pagehelper.PageInfo;
import com.shsxt.base.BaseService;
import com.shsxt.crm.constant.CrmConstant;
import com.shsxt.crm.dao.SaleChanceDao;
import com.shsxt.crm.query.SaleChanceQuery;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.vo.SaleChance;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SaleChanceService extends BaseService<SaleChance> {

    @Resource
    private SaleChanceDao saleChanceDao;

    /**
     * 删除记录
     *  校验参数 是否选择记录
     * @param ids
     */
    public void deleteSaleChance(Integer[] ids) {
        AssertUtil.isTrue(null ==ids || ids.length==0,"至少选择一个删除记录");
        AssertUtil.isTrue(saleChanceDao.delete(ids)<ids.length,CrmConstant.OPS_FAILED_MSG);
    }
    /**
     * 更新记录
     * 1.校验参数
     *  id,id记录必须存在
     *  客户名称
     *  联系人
     *  联系电话
     * 2.执行操作
     *  更新时间
     *  分配人,分配状态
     *
     * @param saleChance
     * @return
     */
    public void updateSaleChance(SaleChance saleChance) {
        checkParams(saleChance.getId(),saleChance.getCustomerName(),saleChance.getLinkMan(),saleChance.getLinkPhone());
        if(null != saleChance.getAssignId()){ //存在分配人
            saleChance.setState(1);
            saleChance.setAssignTime(new Date());
        }
        AssertUtil.isTrue(saleChanceDao.update(saleChance)<1,CrmConstant.OPS_FAILED_MSG);

    }

    /**
     * 校验修改参数
     * @param id
     * @param customerName
     * @param linkMan
     * @param linkPhone
     */
    private void checkParams(Integer id, String customerName, String linkMan, String linkPhone) {
        checkParams(customerName,linkMan,linkPhone);
        AssertUtil.isTrue(null==id || null==saleChanceDao.selectById(id),CrmConstant.OPS_FAILED_MSG);
    }

    /**
     * 添加记录
     *  1.校验参数
     *     客户名称不可为空
     *     联系人.
     *     联系电话不可为空
     *  2.执行操作,
     *      设置分配状态: 默认0 :未分配
     *      若有分配人 则为1 已分配
     *      新添加均为未开发状态:0
     *      判断操作是否成功
     * @param saleChance
     */
    public  void saveSaleChance(SaleChance saleChance){
        checkParams(saleChance.getCustomerName(),saleChance.getLinkMan(),saleChance.getLinkPhone());
        saleChance.setIsValid(1);
        saleChance.setState(0);
        if(null != saleChance.getAssignId()){
            saleChance.setState(1);
            saleChance.setAssignTime(new Date());
        }
        saleChance.setDevResult(0);
        saleChance.setCreateDate(new Date());
        saleChance.setUpdateDate(new Date());

        AssertUtil.isTrue(saleChanceDao.insert(saleChance)<1,CrmConstant.OPS_FAILED_MSG);
    }

    /**
     * 校验参数:客户名称,联系人,联系电话
     * @param customerName
     * @param linkMan
     * @param linkPhone
     */
    private void checkParams(String customerName, String linkMan, String linkPhone) {
        AssertUtil.isTrue(StringUtils.isBlank(customerName),"客户名称不可为空!");
        AssertUtil.isTrue(StringUtils.isBlank(linkMan),"联系人不可为空!");
        AssertUtil.isTrue(StringUtils.isBlank(linkPhone),"请输入联系方式!!!");
    }

    /**
     * 查询saleChance列表
     * @param saleChanceQuery
     * @return
     */
    public  Map<String,Object> querySaleChancesByParams(SaleChanceQuery saleChanceQuery){
        Map<String,Object> map=new HashMap<>();
        PageInfo<SaleChance> pageInfo=queryForPage(saleChanceQuery);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }



}
