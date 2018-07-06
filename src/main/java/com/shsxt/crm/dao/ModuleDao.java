package com.shsxt.crm.dao;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.vo.Module;
import com.shsxt.crm.vo.ModuleTree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 模板管理
 * @author 殇丶无求
 */
public interface ModuleDao extends BaseDao<Module> {



    /**
     * 删除
     * @param ids
     * @return
     */
    Integer deleteModule(@Param(value = "ids") String ids);

    /**
     * 根据层级获取记录
     * @param grade
     * @return
     */
    List<Module> findNameByGrade(@Param(value = "grade") Integer grade);

    /**
     * 获取所有资源
     * @return
     */
    List<ModuleTree> findAll();

    /**
     * 根据权限ID,获取资源ID
     * @param roleId
     * @return
     */
    List<Integer> findMIdByRoleId(@Param(value = "roleId") Integer roleId);
}
