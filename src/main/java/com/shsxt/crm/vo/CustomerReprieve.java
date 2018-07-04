package com.shsxt.crm.vo;

import com.shsxt.base.BaseModel;

/**
 * 客户流失暂缓措施
 */
public class CustomerReprieve extends BaseModel {

    /**客户流失ID**/
    private Integer lossId;
    /**方案**/
    private String measure;

    public Integer getLossId() {
        return lossId;
    }

    public void setLossId(Integer lossId) {
        this.lossId = lossId;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }
}
