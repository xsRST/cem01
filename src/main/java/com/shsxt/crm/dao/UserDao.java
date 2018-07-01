package com.shsxt.crm.dao;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.vo.User;

import java.util.List;
import java.util.Map;

/**
 * @author 殇丶无求
 */
public interface UserDao extends BaseDao<User> {

    /**
     * 根据条件查询记录
     * @param useName
     * @return
     */
    public User selectByName(String useName);

    /**
     * 查询id,和用户真实名称,分配客户
     * @return
     */
    public List<Map<String, Object>> querySaleCustomerManager();
}