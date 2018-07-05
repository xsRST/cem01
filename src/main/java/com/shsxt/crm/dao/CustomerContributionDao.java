package com.shsxt.crm.dao;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.dao.provide.ReportProvider;
import com.shsxt.crm.query.CustomerQuery;
import com.shsxt.crm.vo.CustomerContribution;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author 殇丶无求
 */
public interface CustomerContributionDao extends BaseDao<CustomerContribution> {


    /**
     *  客户贡献分析
     * @param customerQuery
     * @return
     */
    @SelectProvider(type=ReportProvider.class, method="findContribution")
    public List<CustomerContribution> selectByParams(CustomerQuery customerQuery);

}
