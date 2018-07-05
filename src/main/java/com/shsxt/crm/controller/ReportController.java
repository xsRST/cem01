package com.shsxt.crm.controller;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.query.CustomerQuery;
import com.shsxt.crm.service.ReportService;
import com.shsxt.crm.vo.CustomerConstitute;
import com.shsxt.crm.vo.CustomerServeAnalysis;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 报表管理
 * @author 殇丶无求
 */
@RequestMapping("report")
@Controller
public class ReportController extends BaseController {
    @Resource
    private ReportService reportService;
    @RequestMapping("/{page}/index")
    public String index(@PathVariable String page) {
        return "report_" + page;
    }

    /**
     * 查询客户贡献列表
     * @param customerQuery
     * @return
     */
    @RequestMapping("customer_list")
    @ResponseBody
    public Map<String,Object> queryContribution(CustomerQuery customerQuery){
        return reportService.queryByParams(customerQuery);
    }

    /**
     * 查询客户构成
     * @return
     */
    @RequestMapping("find_constitute")
    @ResponseBody
    public ResultInfo<CustomerConstitute> findConstitute(){
        List<CustomerConstitute> list=reportService.findConstitute();
        return success(list);
    }

    /**
     * 客户服务分析
     * @return
     */
    @RequestMapping("find_server_analysis")
    @ResponseBody
    public ResultInfo<CustomerServeAnalysis> findServerAnalysis(){
        List<CustomerServeAnalysis> list=reportService.findServeAnalysis();
        return success(list);
    }

}
