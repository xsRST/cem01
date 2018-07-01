package com.shsxt.crm.vo;

import com.shsxt.base.BaseModel;

/**
 * 字典
 * @author 殇丶无求
 */
public class Datadic extends BaseModel {

    /**字典名称**/
    private String dataDicName;
    /**字典对应的值**/
    private String dataDicValue;

    public String getDataDicName() {
        return dataDicName;
    }

    public void setDataDicName(String dataDicName) {
        this.dataDicName = dataDicName;
    }

    public String getDataDicValue() {
        return dataDicValue;
    }

    public void setDataDicValue(String dataDicValue) {
        this.dataDicValue = dataDicValue;
    }
}
