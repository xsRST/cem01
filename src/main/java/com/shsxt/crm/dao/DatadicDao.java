package com.shsxt.crm.dao;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.vo.Datadic;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 殇丶无求
 */
public interface DatadicDao extends BaseDao<Datadic> {

    /**
     * 通过名称获取对应的value值
     * @param dataDicName
     * @return
     */
    public List<Datadic> findValues(String dataDicName);

    /**
     * 查询所有名字
     * @return
     */
    @Select("SELECT ID,DATA_DIC_NAME FROM T_DATADIC WHERE IS_VALID=1 GROUP BY DATA_DIC_NAME")
    List<Datadic> findAllName();

    /**
     * 删除
     * @param ids
     * @return
     */
    Integer deleteDatadic(@Param(value = "ids") String ids);
}
