package com.shsxt.crm.service;

import com.github.pagehelper.PageInfo;
import com.shsxt.base.BaseQuery;
import com.shsxt.base.BaseService;
import com.shsxt.crm.dao.RoleDao;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.vo.Role;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 殇丶无求
 */
@Service
public class RoleService extends BaseService<Role> {

    @Resource
    private RoleDao roleDao;

    /**
     * 条件查询列表
     * @param roleQuery
     * @return
     */
    public Map<String,Object> selectByPatams(BaseQuery roleQuery) {
        Map<String,Object> map=new HashMap<>(2);
        PageInfo<Role> pageInfo =queryForPage(roleQuery);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    /**
     * 删除
     * @param ids
     */
    public void deleteRole(String ids) {
        AssertUtil.isTrue(StringUtils.isBlank(ids),"请选择需要删除的记录");
        AssertUtil.isTrue(roleDao.deleteRole(ids)<ids.split(",").length,"添加失败");
    }

    /**
     * 添加
     * @param role
     */
    public void addRole(Role role) {
        checkParams(role);
        //根据名称获取记录
        Role role1=roleDao.selectByName(role.getRoleName());
        //如存在,判断是否失效,失效执行更新,有效提示角色已存在
        if(null!= role1){
            if(1 !=role1.getIsValid()){
                role.setIsValid(1);
                role.setId(role1.getId());
                updateRole(role);
                return;
            }
            AssertUtil.isTrue(1==1,"角色已存在");
        }
        role.setIsValid(1);
        role.setCreateDate(new Date());
        role.setUpdateDate(new Date());
        AssertUtil.isTrue(roleDao.insert(role)<1,"添加失败");
    }


    /**
     * 更新
     * @param role
     */
    public void updateRole(Role role) {
        AssertUtil.isTrue(null==role.getId()||role.getId()<0,"请选择需要更新的数据");
        checkParams(role);
        role.setUpdateDate(new Date());
        AssertUtil.isTrue(roleDao.update(role)<1,"更新失败");
    }
    /**
     * 检验参数
     * @param role
     */
    private void checkParams(Role role) {
        AssertUtil.isTrue(StringUtils.isBlank(role.getRoleName()),"请输入角色名称");
        AssertUtil.isTrue(StringUtils.isBlank(role.getRoleRemark()),"请输入角色描述");
    }
}
