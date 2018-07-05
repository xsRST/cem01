package com.shsxt.crm.query;

import com.shsxt.base.BaseQuery;

/**
 * 字典
 * @author 殇丶无求
 */
public class ProductQuery extends BaseQuery {

    /**产品名称**/
    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName.trim();
    }
}
