package com.shsxt.crm.dao;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.vo.User;

public interface UserDao extends BaseDao<User> {

    /**
     * 根据条件查询记录
     * @param user_name
     * @return
     */
    public User selectByName(String user_name);

}