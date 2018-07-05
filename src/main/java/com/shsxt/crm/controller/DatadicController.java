package com.shsxt.crm.controller;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.query.DatadicQuery;
import com.shsxt.crm.service.DatadicService;
import com.shsxt.crm.vo.Datadic;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 殇丶无求
 */
@RequestMapping("datadic")
@Controller
public class DatadicController extends BaseController<Datadic> {

    @Resource
    private DatadicService datadicService;

    @RequestMapping("index")
    public String index(){
        return "datadic";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> list(DatadicQuery datadicQuery){
        return datadicService.selectByPatams(datadicQuery);
    }
    /**
     * 找到对应的value值
     * @param dataDicName
     * @return
     */
    @RequestMapping("findValues")
    @ResponseBody
    public List<Datadic> findValues(String dataDicName){
        return datadicService.findValues(dataDicName);
    }

    /**
     * 查询所有字典名
     * @return
     */
    @RequestMapping("findAllName")
    @ResponseBody
    public List<Datadic> findAllName(){
        return datadicService.findAllName();
    }

    /**
     * 删除字典数据
     * @param ids
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo<Datadic> delete(String ids){

        datadicService.deleteDatadic(ids);
        return success("删除成功");
    }
    /**
     * 添加字典数据
     * @param datadic
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public ResultInfo<Datadic> add(Datadic datadic){
        datadicService.addDatadic(datadic);
        return success("添加成功");
    }
    /**
     * 更新字典数据
     * @param datadic
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public ResultInfo<Datadic> update(Datadic datadic, HttpServletResponse response){
        datadicService.updateDatadic(datadic);
        return success("更新成功");
    }

}
