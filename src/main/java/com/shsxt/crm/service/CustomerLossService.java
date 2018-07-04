package com.shsxt.crm.service;

import com.github.pagehelper.PageInfo;
import com.shsxt.base.BaseService;
import com.shsxt.crm.dao.CustomerLossDao;
import com.shsxt.crm.query.CustomerLossQuery;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.vo.CustomerLoss;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 客户流失
 * @author 殇丶无求
 */
@Service
public class CustomerLossService extends BaseService<CustomerLoss> {

    @Resource
    private CustomerLossDao customerLossDao;


    /**
     * 查询客户流失列表
     * @return
     */
    public Map<String,Object> queryCustomerLossesByParams(CustomerLossQuery query) {
        Map<String,Object> map=new HashMap<>(6);
        PageInfo<CustomerLoss> pageInfo =queryForPage(query);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    /**
     * 更新客户流失状态
     * @param customerLoss
     */
    public void updateCustomerLossState(CustomerLoss customerLoss) {
        Integer state = customerLoss.getState();
        AssertUtil.isTrue(null==state,"请选择流失状态");
        customerLoss.setCreateDate(new Date());
        customerLoss.setUpdateDate(new Date());
        customerLoss.setIsValid(1);
        AssertUtil.isTrue(customerLossDao.updateCustomerLossState(customerLoss)<1,"更新状态失败");
    }
}
