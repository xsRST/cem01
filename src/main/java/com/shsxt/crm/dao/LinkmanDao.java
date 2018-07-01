package com.shsxt.crm.dao;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.vo.Linkman;

/**
 * @author 殇丶无求
 */
public interface LinkmanDao extends BaseDao<Linkman> {

    /**
     * 通过客户名字获取记录
     * @param name
     * @return
     */
    Linkman selectByNmae(String name);
}
