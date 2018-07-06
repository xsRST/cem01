package com.shsxt.crm.vo;

import com.shsxt.base.BaseModel;

/**
 * 角色管理
 * @author 殇丶无求
 */
public class Role extends BaseModel {
    /**角色名称**/
    private String roleName;
    /**角色描述**/
    private String roleRemark;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName==null?null:roleName.trim();
    }

    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark==null?null:roleRemark.trim();
    }
}
