package com.shsxt.crm.controller;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.service.CusDevPlanService;
import com.shsxt.crm.service.SaleChanceService;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.vo.CusDevPlan;
import com.shsxt.crm.vo.SaleChance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 殇丶无求
 */
@RequestMapping("cusDevPlan")
@Controller
public class CusDevPlanController extends BaseController<CusDevPlan> {

    @Resource
    private SaleChanceService saleChanceService;

    @Autowired
    private CusDevPlanService cusDevPlanService;

    @GetMapping("{saleChanceId}/update_dev_result")
    @ResponseBody
    public ResultInfo<CusDevPlan> updateDevResult(@PathVariable Integer saleChanceId,Integer devResult){
        saleChanceService.updateDevResult(saleChanceId,devResult);
        return success("提交成功");
    }

    /**
     * 删除客户计划
     * @param saleChanceId
     * @param id
     * @return
     */
    @PostMapping("{saleChanceId}/delete")
    @ResponseBody
    public ResultInfo<CusDevPlan> deletePlan(@PathVariable Integer saleChanceId, Integer id){
        cusDevPlanService.deletePlan(saleChanceId,id);
        return success("删除成功");
    }
    /**
     * 更新客户计划
     * @param saleChanceId
     * @param cusDevPlan
     * @return
     */
    @PostMapping("{saleChanceId}/update")
    @ResponseBody
    public ResultInfo<CusDevPlan> updatePlan(@PathVariable Integer saleChanceId,CusDevPlan cusDevPlan){
        cusDevPlanService.updatePlan(saleChanceId,cusDevPlan);
        return success("更新成功");
    }

    /**
     * 添加计划
     * @param saleChanceId
     * @param cusDevPlan
     * @return
     */
    @PostMapping("{saleChanceId}/add")
    @ResponseBody
    public CusDevPlan addPlan(@PathVariable Integer saleChanceId,CusDevPlan  cusDevPlan){
        cusDevPlanService.addPlan(saleChanceId,cusDevPlan);
        return cusDevPlan;
    }
    /**
     * 显示当前客户的所有计划
     * @param saleChanceId
     * @return
     */
    @RequestMapping("{saleChanceId}/list_plan")
    @ResponseBody
    public List<CusDevPlan> queryByParams(@PathVariable(value = "saleChanceId") Integer saleChanceId){
        return cusDevPlanService.queryBySaleChanceId(saleChanceId);
    }
    /**
     * 跳转到相应页面
     * @param
     * @return
     */
    @RequestMapping("{saleChanceId}/index")
    public String index(@PathVariable(value = "saleChanceId") Integer saleChanceId, Model model,Integer show){
        SaleChance saleChance=saleChanceService.selectById(saleChanceId);
        AssertUtil.isTrue(null==saleChance,"客户不存在");
        model.addAttribute("saleChance",saleChance);
        model.addAttribute("show",show);
        return "cus_dev_plan";
    }
}
