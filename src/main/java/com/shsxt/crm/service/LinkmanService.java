package com.shsxt.crm.service;

import com.github.pagehelper.PageInfo;
import com.shsxt.base.BaseService;
import com.shsxt.crm.dao.LinkmanDao;
import com.shsxt.crm.query.LinkmanQuery;
import com.shsxt.crm.vo.Linkman;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 殇丶无求
 */
@Service
public class LinkmanService extends BaseService<Linkman> {

    @Resource
    private LinkmanDao linkmanDao;

    /**
     * 查询客户列表
     * @param linkmanQuery
     * @return
     */
    public Map<String,Object> queryByParams(LinkmanQuery linkmanQuery) {
        Map<String,Object> map=new HashMap<>(6);
        PageInfo<Linkman> pageInfo=queryForPage(linkmanQuery);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }




}
