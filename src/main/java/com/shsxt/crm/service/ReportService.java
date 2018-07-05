package com.shsxt.crm.service;

import com.github.pagehelper.PageInfo;
import com.shsxt.base.BaseService;
import com.shsxt.crm.dao.CustomerDao;
import com.shsxt.crm.dao.CustomerServeDao;
import com.shsxt.crm.query.CustomerQuery;
import com.shsxt.crm.vo.CustomerConstitute;
import com.shsxt.crm.vo.CustomerContribution;
import com.shsxt.crm.vo.CustomerServeAnalysis;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报表
 * @author 殇丶无求
 */
@Service
public class ReportService extends BaseService<CustomerContribution>  {

    @Resource
    private CustomerDao customerDao;

    @Resource
    private CustomerServeDao customerServeDao;
    /**
     * 根据条件分页查询列表
     * @param customerQuery
     * @return
     */
    public Map<String,Object> queryByParams(CustomerQuery customerQuery) {
        PageInfo<CustomerContribution> pageInfo = queryForPage(customerQuery);
        Map<String, Object> result = new HashMap<>(4);
        result.put("rows", pageInfo.getList());
        result.put("total", pageInfo.getTotal());
        return result;
    }
    /**
     * 统计客户构成
     * @return
     */
    public List<CustomerConstitute> findConstitute() {
        List<CustomerConstitute> constitutes = customerDao.findConstitute();
        return constitutes;
    }

    /**
     * 统计服务分析
     * @return
     */
    public List<CustomerServeAnalysis> findServeAnalysis() {
        List<CustomerServeAnalysis> result = customerServeDao.findServeAnalysis();
        return result;

    }
}
