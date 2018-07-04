package com.shsxt.crm.dao;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.dao.provide.CustomerLossProvider;
import com.shsxt.crm.query.CustomerLossQuery;
import com.shsxt.crm.vo.CustomerLoss;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * 客户流失
 * @author 殇丶无求
 */
public interface CustomerLossDao extends BaseDao<CustomerLoss> {

    /**
     * 查询
     * @param query
     * @return
     * @throws DataAccessException
     */
    @SelectProvider(type = CustomerLossProvider.class,method = "selectByParams")
    List<CustomerLoss> selectByParams(CustomerLossQuery query) throws DataAccessException;

    /**
     * 根据主键ID查看记录
     * @param id
     * @return
     * @throws DataAccessException
     */
    @Override
    @Select("SELECT ID,CUS_NAME,CUS_NO,CUS_MANAGER,LAST_ORDER_TIME,CONFIRM_LOSS_TIME,STATE,LOSS_REASON " +
            " FROM T_CUSTOMER_LOSS " +
            " WHERE ID=#{id} AND IS_VALID=1")
    public CustomerLoss selectById(@Param(value = "id") Integer id)throws DataAccessException;

    /**
     * 更新客户流失状态
     * @param customerLoss
     * @return
     */
    @Update("UPDATE T_CUSTOMER_LOSS SET CONFIRM_LOSS_TIME=#{confirmLossTime}," +
                "STATE=#{state}," +
                "LOSS_REASON=#{lossReason}," +
                "IS_VALID=#{isValid}," +
                "CREATE_DATE=#{createDate}," +
                "UPDATE_DATE=#{updateDate} " +
                "WHERE ID=#{id}")
    Integer updateCustomerLossState(CustomerLoss customerLoss);
}
