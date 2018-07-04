package com.shsxt.crm.dao;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.query.CustomerReprieveQuery;
import com.shsxt.crm.vo.CustomerReprieve;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import java.util.Date;
import java.util.List;

/**
 * 客户流失措施
 * @author 殇丶无求
 */
public interface CustomerReprieveDao extends BaseDao<CustomerReprieve> {

    /**
     * 根据主键id查询唯一值
     * @param id
     * @return
     * @throws DataAccessException
     */
    @Select("SELECT ID,LOSS_ID,MEASURE,IS_VALID FROM T_CUSTOMER_REPRIEVE WHERE IS_VALID=1 AND ID=#{id}")
    @Override
    public CustomerReprieve selectById(@Param(value = "id") Integer id) throws DataAccessException;

    /**
     *  根据流失客户IDid查询
     * @param customerReprieveQuery
     * @return
     * @throws DataAccessException
     */
    @Select("SELECT ID,LOSS_ID,MEASURE,IS_VALID FROM T_CUSTOMER_REPRIEVE WHERE IS_VALID=1 AND LOSS_ID=#{lossId}")
    public List<CustomerReprieve> selectByParams(CustomerReprieveQuery customerReprieveQuery) throws DataAccessException;

    /**
     * 添加暂缓措施
     * @param customerReprieve
     * @return
     * @throws DataAccessException
     */
    @Insert("INSERT INTO T_CUSTOMER_REPRIEVE(LOSS_ID,MEASURE,IS_VALID,CREATE_DATE,UPDATE_DATE) " +
            " VALUES(#{lossId},#{measure},#{isValid},#{createDate},#{updateDate})")
    @Options(keyProperty = "id",keyColumn = "id",useGeneratedKeys =true)
    @Override
    public Integer insert(CustomerReprieve customerReprieve) throws DataAccessException;

    /**
     * 更新暂缓措施
     * @param customerReprieve
     * @return
     * @throws DataAccessException
     */
    @Insert(" UPDATE T_CUSTOMER_REPRIEVE SET measure=#{measure},update_date=#{updateDate}) " +
            " WHERE ID=#{id}")
    @Override
    public Integer update(CustomerReprieve customerReprieve) throws DataAccessException;

    /**
     * 删除暂缓措施
     * @param id
     * @param updateDate
     * @return
     * @throws DataAccessException
     */
    @Insert(" UPDATE T_CUSTOMER_REPRIEVE SET IS_VALID=0,update_date=#{updateDate} " +
            " WHERE ID=#{id}")
    public Integer delete(@Param(value = "id") Integer id,@Param(value = "updateDate") Date updateDate) throws DataAccessException;

}
