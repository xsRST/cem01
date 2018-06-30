package com.shsxt.crm.service;

import com.shsxt.base.BaseService;
import com.shsxt.crm.dao.DatadicDao;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.vo.Datadic;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
}
