package com.shsxt.crm.dao;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.query.LinkmanQuery;
import com.shsxt.crm.vo.Linkman;

import java.util.List;

/**
 * @author 殇丶无求
 */
public interface LinkmanDao extends BaseDao<Linkman> {

    /**
     * 通过客户Id和联系人名称,手机号,性别获取获取记录
     * @param linkmanQuery
     * @return
     */
    List<Linkman> queryByParams(LinkmanQuery linkmanQuery);

    /**
     * 删除单个客户联系人
     * @param cusId
     * @return
     */
    Integer delete(Integer cusId);
}
