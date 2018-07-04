package com.shsxt.crm.query;

import com.shsxt.base.BaseQuery;

/**
 * 流失客户措施条件
 * @author 殇丶无求
 */
public class CustomerReprieveQuery extends BaseQuery {
    /**流失客户ID**/
    private Integer lossId;

    public Integer getLossId() {
        return lossId;
    }

    public void setLossId(Integer lossId) {
        this.lossId = lossId;
    }
}
