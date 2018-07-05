package com.shsxt.crm.service;

import com.github.pagehelper.PageInfo;
import com.shsxt.base.BaseService;
import com.shsxt.crm.dao.DatadicDao;
import com.shsxt.crm.query.DatadicQuery;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.vo.Datadic;
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
public class DatadicService  extends BaseService<Datadic> {

    @Resource
    private DatadicDao datadicDao;
    /**
     * 通过名字查询对应value
     * @param dataDicName
     * @return
     */
    public List<Datadic> findValues(String dataDicName) {
        /*
            1.参数校验
         */
        AssertUtil.isTrue(StringUtils.isBlank(dataDicName),"请输入要查询的名称");

        return datadicDao.findValues(dataDicName);
    }

    /**
     * 查询所有名称
     * @return
     */
    public List<Datadic> findAllName() {
        return datadicDao.findAllName();
    }

    /**
     * 条件查询列表
     * @param datadicQuery
     * @return
     */
    public Map<String,Object> selectByPatams(DatadicQuery datadicQuery) {
        Map<String,Object> map=new HashMap<>(2);
        PageInfo<Datadic> pageInfo =queryForPage(datadicQuery);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    /**
     * 删除
     * @param ids
     */
    public void deleteDatadic(String ids) {
        AssertUtil.isTrue(StringUtils.isBlank(ids),"请选择需要删除的记录");

        AssertUtil.isTrue(datadicDao.deleteDatadic(ids)<ids.split(",").length,"添加失败");
    }

    /**
     * 添加
     * @param datadic
     */
    public void addDatadic(Datadic datadic) {
        AssertUtil.isTrue(StringUtils.isBlank(datadic.getDataDicName()),"请输入添加的名称");
        AssertUtil.isTrue(StringUtils.isBlank(datadic.getDataDicValue()),"请输入添加的值");
        datadic.setCreateDate(new Date());
        datadic.setUpdateDate(new Date());
        datadic.setIsValid(1);
        AssertUtil.isTrue(datadicDao.insert(datadic)<1,"添加失败");

    }

    /**
     * 更新
     * @param datadic
     */
    public void updateDatadic(Datadic datadic) {
        AssertUtil.isTrue(null==datadic.getId()||datadic.getId()<0,"请选择需要更新的数据");
        AssertUtil.isTrue(StringUtils.isBlank(datadic.getDataDicName()),"请输入更新的名称");
        AssertUtil.isTrue(StringUtils.isBlank(datadic.getDataDicValue()),"请输入更新的值");
        datadic.setUpdateDate(new Date());
        AssertUtil.isTrue(datadicDao.update(datadic)<1,"更新失败");
    }
}
