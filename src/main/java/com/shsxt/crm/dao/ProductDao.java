package com.shsxt.crm.dao;

import com.shsxt.base.BaseDao;
import com.shsxt.crm.vo.Product;
import org.apache.ibatis.annotations.Param;

/**
 * @author 殇丶无求
 */
public interface ProductDao extends BaseDao<Product> {



    /**
     * 删除
     * @param ids
     * @return
     */
    Integer deleteProduct(@Param(value = "ids") String ids);
}
