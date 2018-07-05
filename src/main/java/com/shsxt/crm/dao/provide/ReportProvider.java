package com.shsxt.crm.dao.provide;

import com.shsxt.crm.query.CustomerQuery;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * 报表
 * @author 殇丶无求
 */
public class ReportProvider {

    /**
     * 查询客户贡献列表
     * @return
     */
    public String findContribution(CustomerQuery customerQuery){

        String sql=new SQL(){{
            SELECT("t1.`name` as name,SUM(sum) AS  amount");
            FROM("T_customer t1").LEFT_OUTER_JOIN("T_CUSTOMER_ORDER t2 ON t1.id=t2.CUS_ID");
            LEFT_OUTER_JOIN("T_ORDER_DETAILS t3 ON t2.id=t3.ORDER_ID");
            if(StringUtils.isNotBlank(customerQuery.getName())){
                WHERE("t1.`name`=#{name}");
            }
            GROUP_BY("t1.`name`");
            ORDER_BY("amount desc");
        }}.toString();
        return sql;
    }
}
