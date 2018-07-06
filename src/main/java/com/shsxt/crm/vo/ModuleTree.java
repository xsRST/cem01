package com.shsxt.crm.vo;

import com.shsxt.base.BaseModel;

/**
 * 关联权限树
 * @author 殇丶无求
 */
public class ModuleTree extends BaseModel {
    private Integer pId;
    private String name;
    private boolean open = true;
    private boolean checked;


    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
