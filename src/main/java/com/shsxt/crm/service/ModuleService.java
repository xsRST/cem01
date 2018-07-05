package com.shsxt.crm.service;

import com.github.pagehelper.PageInfo;
import com.shsxt.base.BaseQuery;
import com.shsxt.base.BaseService;
import com.shsxt.crm.dao.ModuleDao;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.vo.Module;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 殇丶无求
 */
@Service
public class ModuleService extends BaseService<Module> {

    @Resource
    private ModuleDao moduleDao;


    /**
     * 条件查询列表
     * @param moduleQuery
     * @return
     */
    public Map<String,Object> selectByPatams(BaseQuery moduleQuery) {
        Map<String,Object> map=new HashMap<>(2);
        PageInfo<Module> pageInfo =queryForPage(moduleQuery);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    /**
     * 删除
     * @param ids
     */
    public void deleteModule(String ids) {
        AssertUtil.isTrue(StringUtils.isBlank(ids),"请选择需要删除的记录");
        AssertUtil.isTrue(moduleDao.deleteModule(ids)<ids.split(",").length,"添加失败");
    }

    /**
     * 添加
     * @param module
     */
    public void addModule(Module module) {
        checkParams(module);
        //设置父级菜单的操作权限
        String parentOpValue=getParentOptValue(module);
        module.setParentOptValue(parentOpValue);
        module.setIsValid(1);
        module.setCreateDate(new Date());
        module.setUpdateDate(new Date());
        AssertUtil.isTrue(moduleDao.insert(module)<1,"添加失败");
    }

    /**
     * 获取父级菜单的操作权限,
     * @param module
     * @return
     */
    private String getParentOptValue(Module module) {
        if(module.getGrade()!=0){
            AssertUtil.isTrue(null==module.getParentId()||module.getParentId()<0,"请选择父级菜单");
            Module module1=selectById(module.getParentId());
            AssertUtil.isTrue(null==module1,"父级菜单不存在");
            if(null!=module){
                return module1.getOptValue();
            }
        }
        return null;
    }


    /**
     * 更新
     * @param module
     */
    public void updateModule(Module module) {
        AssertUtil.isTrue(null==module.getId()||module.getId()<0,"请选择需要更新的数据");
        checkParams(module);
        //设置父级菜单的操作权限
        String parentOpValue=getParentOptValue(module);
        module.setParentOptValue(parentOpValue);
        module.setUpdateDate(new Date());
        AssertUtil.isTrue(moduleDao.update(module)<1,"更新失败");
    }
    /**
     * 检验参数
     * @param module
     */
    private void checkParams(Module module) {
        AssertUtil.isTrue(StringUtils.isBlank(module.getModuleName()),"请输入模板名称");
        AssertUtil.isTrue(null==module.getOrders()||module.getOrders()<1,"请输入排序位置");
        AssertUtil.isTrue(StringUtils.isBlank(module.getUrl()),"请输入路径/方法");
        AssertUtil.isTrue(StringUtils.isBlank(module.getOptValue()),"请输入操作权限");
        AssertUtil.isTrue(null==module.getGrade()||module.getGrade()<0,"请选择层级");

    }

    /**
     * 根据层级获取名称
     * @param grade
     * @return
     */
    public List<Module> findNameByGrade(Integer grade) {
        AssertUtil.isTrue(null==grade||grade<0,"请选择层级");
        return moduleDao.findNameByGrade(grade);
    }
}
