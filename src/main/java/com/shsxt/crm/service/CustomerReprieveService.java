package com.shsxt.crm.service;

import com.github.pagehelper.PageInfo;
import com.shsxt.base.BaseService;
import com.shsxt.crm.dao.CustomerReprieveDao;
import com.shsxt.crm.query.CustomerReprieveQuery;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.vo.CustomerReprieve;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 客户流失暂缓措施
 * @author 殇丶无求
 */
@Service
public class CustomerReprieveService extends BaseService<CustomerReprieve> {

    @Resource
    private CustomerReprieveDao customerReprieveDao;

    /**
     * 根据流失ID 查询列表
     * @param customerReprieveQuery
     * @return
     */
    public Map<String,Object> selectByLossId(CustomerReprieveQuery customerReprieveQuery){
        Map<String,Object> map=new HashMap<>(4);
        Integer lossId=customerReprieveQuery.getLossId();
        AssertUtil.isTrue(null==lossId||lossId<0,"请选择需要查看的客户ID");
        PageInfo<CustomerReprieve> pageInfo=queryForPage(customerReprieveQuery);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }



    /**
     * 添加客户流失措施
     * @param customerReprieve
     * @return
     */
    public void insert(CustomerReprieve customerReprieve) {
        AssertUtil.isTrue(StringUtils.isBlank(customerReprieve.getMeasure()),"请输入暂缓措施");
        customerReprieve.setCreateDate(new Date());
        customerReprieve.setUpdateDate(new Date());
        customerReprieve.setIsValid(1);
        AssertUtil.isTrue(customerReprieveDao.insert(customerReprieve)<1,"添加失败");
    }

    /**
     * 更新客户流失措施
     * @param customerReprieve
     */
    public void update(CustomerReprieve customerReprieve) {
        AssertUtil.isTrue(StringUtils.isBlank(customerReprieve.getMeasure()),"请输入暂缓措施");
        Integer id=customerReprieve.getId();
        AssertUtil.isTrue(null==id||id<0,"请选择需要更新的记录");
        customerReprieve.setUpdateDate(new Date());
        AssertUtil.isTrue(customerReprieveDao.update(customerReprieve)<1,"更新失败");
    }

    /**
     * 删除客户流失措施
     * @param id
     */
    public void delete(Integer id){
        AssertUtil.isTrue(null==id||id<0,"请选择需要删除的记录");
        AssertUtil.isTrue(customerReprieveDao.delete(id,new Date())<1,"删除失败");
    }
}
