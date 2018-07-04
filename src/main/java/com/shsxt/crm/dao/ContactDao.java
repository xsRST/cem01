package com.shsxt.crm.dao;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.query.ContactQuery;
import com.shsxt.crm.vo.Contact;

import java.util.List;

/**
 * 交易往来
 * @author 殇丶无求
 */
public interface ContactDao extends BaseDao<Contact> {

    /**
     * 通过客户Id和联系人名称,手机号,性别获取获取记录
     * @param contactQuery
     * @return
     */
    List<Contact> queryByParams(ContactQuery contactQuery);

    /**
     * 删除单个客户联系人
     * @param cusId
     * @return
     */
    Integer delete(Integer cusId);

    /**
     * 测试映射
     * @param id
     * @return
     */
    /*@SelectProvider(type = ContactProvider.class,method = "test")
    Integer test(Integer id);*/
}
