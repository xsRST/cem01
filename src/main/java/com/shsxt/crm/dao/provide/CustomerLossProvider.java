package com.shsxt.crm.dao.provide;

import com.shsxt.crm.query.CustomerLossQuery;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * 客户流失
 * @author 殇丶无求
 */
public class CustomerLossProvider {

    /**
     * 查询流失客户列表
     * @param query
     * @return
     */
    public String selectByParams(CustomerLossQuery query){
        String sql=new SQL(){{

            SELECT("ID,CUS_NAME,CUS_MANAGER,LAST_ORDER_TIME,CONFIRM_LOSS_TIME,STATE,LOSS_REASON");
            FROM("T_CUSTOMER_LOSS");
            WHERE("IS_VALID=1");
            if(StringUtils.isNotBlank(query.getCusName())){
                AND().WHERE("CUS_NAME LIKE CONCAT('%',#{cusName},'%')");
            }
            if(StringUtils.isNotBlank(query.getCusManager())){
                AND().WHERE("CUS_MANAGER LIKE CONCAT('%',#{cusManager},'%') ");
            }
            if(null!=query.getState()){
                AND().WHERE("STATE=#{state}");
            }
        }}.toString();
        return sql;
    }
}
