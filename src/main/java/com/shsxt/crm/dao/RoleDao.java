package com.shsxt.crm.dao;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.vo.Role;
import org.apache.ibatis.annotations.Param;

/**
 * 模板管理
 * @author 殇丶无求
 */
public interface RoleDao extends BaseDao<Role> {



    /**
     * 删除
     * @param ids
     * @return
     */
    Integer deleteRole(@Param(value = "ids") String ids);


    /**
     * 根据名字获取记录
     * @param roleName
     * @return
     */
    Role selectByName(@Param(value = "roleName") String roleName);
}
