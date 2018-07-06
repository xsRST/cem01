package com.shsxt.crm.controller;

import com.shsxt.base.BaseController;
import com.shsxt.base.BaseQuery;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.service.ModuleService;
import com.shsxt.crm.service.RoleService;
import com.shsxt.crm.vo.ModuleTree;
import com.shsxt.crm.vo.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 殇丶无求
 */
@RequestMapping("role")
@Controller
public class RoleController extends BaseController<Role> {

    @Resource
    private RoleService roleService;
    @Resource
    private ModuleService moduleService;

    /**
     * 跳转页面
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return "role";
    }

    /**
     * 查询列表
     * @param query
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> list(BaseQuery query){
        return roleService.selectByPatams(query);
    }


    /**
     * 删除数据
     * @param ids
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo<Role> delete(String ids){

        roleService.deleteRole(ids);
        return success("删除成功");
    }
    /**
     * 添加数据
     * @param role
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public ResultInfo<Role> add(Role role){
        roleService.addRole(role);
        return success("添加成功");
    }
    /**
     * 更新数据
     * @param role
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public ResultInfo<Role> update(Role role){
        roleService.updateRole(role);
        return success("更新成功");
    }

    /**
     * 跳转到关联权限页面
     * @param roleId
     * @param model
     * @return
     */
    @RequestMapping("{roleId}/index")
    public String relate(@PathVariable(value = "roleId") Integer roleId, Model model){
        Role role=roleService.selectById(roleId);
        List<ModuleTree> modules=moduleService.findAll(roleId);
        model.addAttribute("role",role);
        model.addAttribute("modules",modules);
        return "role_module";
    }
}
