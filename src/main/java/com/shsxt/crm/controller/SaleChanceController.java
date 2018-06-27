package com.shsxt.crm.controller;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.query.SaleChanceQuery;
import com.shsxt.crm.service.SaleChanceService;
import com.shsxt.crm.vo.SaleChance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("saleChance")
public class SaleChanceController extends BaseController<SaleChance> {

    @Resource
    private SaleChanceService saleChanceService;

    /**
     * 删除销售机会记录
     * @param ids
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo<SaleChance> delete(Integer[] ids){
        saleChanceService.deleteSaleChance(ids);
        return success("删除成功");
    }
    /**
     * 修改销售机会数据
     * @param saleChance
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public ResultInfo<SaleChance> update(SaleChance saleChance){
        saleChanceService.updateSaleChance(saleChance);
        return success("修改成功");
    }
    /**
     * 添加销售机会数据
     * @param saleChance
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public ResultInfo<SaleChance> save(SaleChance saleChance){
        saleChanceService.saveSaleChance(saleChance);
        return success("添加成功");
    }
    /**
     * 显示销售机会列表
     * @param page
     * @param rows
     * @param saleChanceQuery
     * @return
     */
    @RequestMapping("querySaleChancesByParams")
    @ResponseBody
    public Map<String,Object> querySaleChancesByParams(@RequestParam(defaultValue = "1")Integer page ,@RequestParam(defaultValue = "10") Integer rows, SaleChanceQuery saleChanceQuery){

        saleChanceQuery.setPageNum(page);
        saleChanceQuery.setPageSize(rows);
        return saleChanceService.querySaleChancesByParams(saleChanceQuery);
    }

    /**
     * 转到销售机会页面
     * @param request
     * @return
     */
    @RequestMapping("index")
    public String index(HttpServletRequest request){
        request.setAttribute("ctx",request.getContextPath());
        return "sale_Chance";
    }


}
