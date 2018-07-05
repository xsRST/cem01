package com.shsxt.crm.controller;

import com.shsxt.base.BaseController;
import com.shsxt.base.BaseQuery;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.service.ModuleService;
import com.shsxt.crm.vo.Module;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 殇丶无求
 */
@RequestMapping("module")
@Controller
public class ModuleController extends BaseController<Module> {

    @Resource
    private ModuleService moduleService;

    @RequestMapping("findNameByGrade")
    @ResponseBody
    public List<Module> findNameByGrade(@RequestParam(value = "grade") Integer grade){
        return moduleService.findNameByGrade(grade);
    }
    /**
     * 跳转页面
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return "module";
    }

    /**
     * 查询模板列表
     * @param query
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> list(BaseQuery query){
        return moduleService.selectByPatams(query);
    }


    /**
     * 删除数据
     * @param ids
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo<Module> delete(String ids){

        moduleService.deleteModule(ids);
        return success("删除成功");
    }
    /**
     * 添加数据
     * @param module
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public ResultInfo<Module> add(Module module){
        moduleService.addModule(module);
        return success("添加成功");
    }
    /**
     * 更新数据
     * @param module
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public ResultInfo<Module> update(Module module){
        moduleService.updateModule(module);
        return success("更新成功");
    }

}
