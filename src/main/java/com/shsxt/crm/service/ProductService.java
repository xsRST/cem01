package com.shsxt.crm.service;

import com.github.pagehelper.PageInfo;
import com.shsxt.base.BaseService;
import com.shsxt.crm.dao.ProductDao;
import com.shsxt.crm.query.ProductQuery;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.vo.Product;
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
public class ProductService extends BaseService<Product> {

    @Resource
    private ProductDao productDao;


    /**
     * 条件查询列表
     * @param productQuery
     * @return
     */
    public Map<String,Object> selectByPatams(ProductQuery productQuery) {
        Map<String,Object> map=new HashMap<>(2);
        PageInfo<Product> pageInfo =queryForPage(productQuery);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    /**
     * 删除
     * @param ids
     */
    public void deleteProduct(String ids) {
        AssertUtil.isTrue(StringUtils.isBlank(ids),"请选择需要删除的记录");
        AssertUtil.isTrue(productDao.deleteProduct(ids)<ids.split(",").length,"添加失败");
    }

    /**
     * 添加
     * @param product
     */
    public void addProduct(Product product) {
        checkParams(product);
        product.setCreateDate(new Date());
        product.setUpdateDate(new Date());
        product.setIsValid(1);
        AssertUtil.isTrue(productDao.insert(product)<1,"添加失败");

    }



    /**
     * 更新
     * @param product
     */
    public void updateProduct(Product product) {
        AssertUtil.isTrue(null==product.getId()||product.getId()<0,"请选择需要更新的数据");
        checkParams(product);
        product.setUpdateDate(new Date());
        AssertUtil.isTrue(productDao.update(product)<1,"更新失败");
    }
    /**
     * 检验参数
     * @param product
     */
    private void checkParams(Product product) {
        AssertUtil.isTrue(StringUtils.isBlank(product.getProductName()),"请输入产品名称");
        AssertUtil.isTrue(StringUtils.isBlank(product.getModel()),"请输入型号");
        AssertUtil.isTrue(StringUtils.isBlank(product.getUnit()),"请输入单位");
        AssertUtil.isTrue(null==product.getPrice()||product.getPrice()<0,"请输入价格");
        AssertUtil.isTrue(StringUtils.isBlank(product.getRemark()),"请输入备注");
    }
}
