package com.shsxt.crm.controller;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.query.ProductQuery;
import com.shsxt.crm.service.ProductService;
import com.shsxt.crm.vo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 *
 * @author 殇丶无求
 */
@RequestMapping("product")
@Controller
public class ProductController extends BaseController<Product> {

    @Resource
    private ProductService productService;

    @RequestMapping("index")
    public String index(){
        return "product";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> list(ProductQuery productQuery){
        return productService.selectByPatams(productQuery);
    }


    /**
     * 删除数据
     * @param ids
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo<Product> delete(String ids){

        productService.deleteProduct(ids);
        return success("删除成功");
    }
    /**
     * 添加数据
     * @param product
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public ResultInfo<Product> add(Product product){
        productService.addProduct(product);
        return success("添加成功");
    }
    /**
     * 更新数据
     * @param product
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public ResultInfo<Product> update(Product product, HttpServletResponse response){
        productService.updateProduct(product);
        return success("更新成功");
    }

}
