package com.shsxt.crm.dao;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.vo.Datadic;

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
}
