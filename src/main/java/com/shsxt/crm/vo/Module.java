package com.shsxt.crm.vo;

import com.shsxt.base.BaseModel;

/**
 * 模板管理
 * @author 殇丶无求
 */
public class Module extends BaseModel {

    /**模板名称**/
    private String moduleName;
    /**模板样式**/
    private String moduleStyle;
    /**路径/方法**/
    private String url;
    /**父级菜单Id**/
    private Integer parentId;
    /**父级菜单名称**/
    private String parentName;
    /**父级操作权限**/
    private String parentOptValue;
    /**操作权限**/
    private String optValue;
    /**层级**/
    private Integer grade;
    /**排序**/
    private Integer orders;


    public String getParentOptValue() {
        return parentOptValue;
    }

    public void setParentOptValue(String parentOptValue) {
        this.parentOptValue = parentOptValue;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleStyle() {
        return moduleStyle;
    }

    public void setModuleStyle(String moduleStyle) {
        this.moduleStyle = moduleStyle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getOptValue() {
        return optValue;
    }

    public void setOptValue(String optValue) {
        this.optValue = optValue;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }
}
