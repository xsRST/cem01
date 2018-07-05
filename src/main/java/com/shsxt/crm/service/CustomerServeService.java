package com.shsxt.crm.service;

import com.github.pagehelper.PageInfo;
import com.shsxt.base.BaseService;
import com.shsxt.crm.dao.CustomerServeDao;
import com.shsxt.crm.dao.UserDao;
import com.shsxt.crm.query.CustomerServeQuery;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.utils.LoginUserUtil;
import com.shsxt.crm.vo.CustomerServe;
import com.shsxt.crm.vo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 客户服务
 * @author 殇丶无求
 */
@Service
public class CustomerServeService extends BaseService<CustomerServe> {

    @Resource
    private CustomerServeDao customerServeDao;

    @Resource
    private UserDao userDao;

    /**
     * 根据条件查询记录
     * @param customerServeQuery
     * @return
     */
    public Map<String,Object> selectByParams(CustomerServeQuery customerServeQuery) {
        Map<String,Object> map=new HashMap<>(4);
        PageInfo<CustomerServe> pageInfo=queryForPage(customerServeQuery);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
    /**
     * 添加服务
     * @param customerServe
     */
    public void insert(CustomerServe customerServe, HttpServletRequest request) {
        checkParamsCreate(customerServe);
        Integer userId=LoginUserUtil.releaseUserIdFromCookie(request);
        User user=userDao.selectById(userId);
        customerServe.setCreatePeople(user.getTrueName());
        customerServe.setCreateDate(new Date());
        customerServe.setUpdateDate(new Date());
        customerServe.setIsValid(1);
        AssertUtil.isTrue(customerServeDao.insert(customerServe)<1,"添加失败");
    }

    /**
     * 更新服务
     * @param customerServe
     */
    public void update(CustomerServe customerServe){
        Integer state=customerServe.getState();
        AssertUtil.isTrue(null==state ||state<0,"系统异常");
        //分配
        if (state== 2) {
            checkParamsAssign(customerServe);
            customerServe.setAssignTime(new Date());
        }
        //处理
        else if (state== 3) {
            checkParamsProceed(customerServe);
            customerServe.setServiceProceTime(new Date());
        }
        //反馈
        else if (state== 4) {
            checkParamsBack(customerServe);
        }
        customerServe.setUpdateDate(new Date());
        AssertUtil.isTrue(customerServeDao.update(customerServe)<1,"更新失败");
    }
    /**
     * 创建检验参数:服务类型,客户名称,概要,服务请求
     * @param customerServe
     */
    private void checkParamsCreate(CustomerServe customerServe) {
        AssertUtil.isTrue(StringUtils.isBlank(customerServe.getServeType()),"请选择服务类型");
        AssertUtil.isTrue(StringUtils.isBlank(customerServe.getCustomer()),"请输入客户名称");
        AssertUtil.isTrue(StringUtils.isBlank(customerServe.getOverview()),"请输入概要");
        AssertUtil.isTrue(StringUtils.isBlank(customerServe.getServiceRequest()),"请输入服务请求");
    }

    /**
     * 分配检验参数:服务类型,客户名称,概要,服务请求,
     *      分配人,分配时间
     * @param customerServe
     */
    private void checkParamsAssign(CustomerServe customerServe) {
        checkParamsCreate(customerServe);
        AssertUtil.isTrue(StringUtils.isBlank(customerServe.getAssigner()),"请选择分配人");
    }
    /**
     * 处理检验参数:服务类型,客户名称,概要,服务请求,
     *      分配人,分配时间
     *      处理内容
     * @param customerServe
     */
    private void checkParamsProceed(CustomerServe customerServe) {
        checkParamsAssign(customerServe);
        AssertUtil.isTrue(StringUtils.isBlank(customerServe.getAssigner()),"请输入服务处理");
    }

    /**
     * 反馈检验参数:服务类型,客户名称,概要,服务请求,
     *      分配人,分配时间
     *        处理内容,处理时间
     *        处理人,处理时间
     *      处理结果,满意度
     * @param customerServe
     */
    private void checkParamsBack(CustomerServe customerServe) {
        checkParamsProceed(customerServe);
        AssertUtil.isTrue(StringUtils.isBlank(customerServe.getServiceProceResult()),"请输入处理结果");
        AssertUtil.isTrue(StringUtils.isBlank(customerServe.getMyd()),"请选择满意度");
    }


}
