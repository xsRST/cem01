package com.shsxt.crm.service;

import com.github.pagehelper.PageInfo;
import com.shsxt.base.BaseService;
import com.shsxt.crm.dao.LinkmanDao;
import com.shsxt.crm.query.LinkmanQuery;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.vo.Linkman;
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
public class LinkmanService extends BaseService<Linkman> {

    @Resource
    private LinkmanDao linkmanDao;


    /**
     * 删除客户联系人
     * @param cusId
     */
    public void deleteLinkman(Integer cusId) {
        AssertUtil.isTrue(null==cusId,"请选择要删除的客户联系人");
        AssertUtil.isTrue(linkmanDao.delete(cusId)<1,"删除失败");
    }
    /**
     * 更新客户联系人
     * @param linkman
     */
    public void updateLinkman(Linkman linkman) {
        /*
            1基本参数校验:
             客户名称唯一性
               设置其他参数:
                    是否有效
                    更新时间
            2.执行方法
         */
        checkCustomerParams(linkman.getId(),linkman.getCusId(),linkman.getLinkName(),linkman.getOfficePhone(),
                linkman.getPhone(),linkman.getZhiwei(),linkman.getSex());
        linkman.setUpdateDate(new Date());
        AssertUtil.isTrue(linkmanDao.update(linkman)<1,"更新失败");
    }

    /**
     * 添加客户联系人
     * @param linkman
     */
    public void addLinkman(Linkman linkman) {
        //基本参数校验
        checkCustomerParams(linkman.getCusId(),linkman.getLinkName(),linkman.getOfficePhone(),
                linkman.getPhone(),linkman.getZhiwei(),linkman.getSex());
        //检验客户联系人名称唯一性:联系人名称,客户ID,性别,手机号
        LinkmanQuery linkmanQuery=new LinkmanQuery();
        linkmanQuery.setCusId(linkman.getCusId());
        linkmanQuery.setLinkName(linkman.getLinkName());
        linkmanQuery.setSex(linkman.getSex());
        linkmanQuery.setPhone(linkman.getPhone());
        List<Linkman> list =linkmanDao.queryByParams(linkmanQuery);

        //若客户联系人已经存在
        if(null!=list & list.size()>0){
            Linkman linkmanDb=list.get(0);
            //若客户联系人是无效客户并且手机号性别一致,执行更新操作
            if(linkmanDb.getIsValid()==0){
                linkman.setId(linkmanDb.getId());
                linkmanDb=linkman;
                linkmanDb.setUpdateDate(new Date());
                //调用更新方法
                updateLinkman(linkmanDb);
                return;
            }
            AssertUtil.isTrue(linkmanDb.getIsValid()==1,"客户联系人已存在");
        }
        //参数设置
        //客户联系人有效
        linkman.setIsValid(1);
        //客户联系人创建时间
        linkman.setCreateDate(new Date());
        //客户联系人更新时间
        linkman.setUpdateDate(new Date());
        //保存数据
        AssertUtil.isTrue(linkmanDao.insert(linkman)<1,"添加失败");
    }


    /**
     * 查询客户联系人列表
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
    private void checkCustomerParams(Integer id,Integer cusId, String linkName, String officePhone, String phone, String zhiwei, String sex) {
        checkCustomerParams(cusId, linkName, officePhone, phone, zhiwei, sex);
        AssertUtil.isTrue(null==id,"请选择联系人");
    }
    /**
     * 检验参数
     * @param cusId
     * @param linkName
     * @param officePhone
     * @param phone
     * @param zhiwei
     * @param sex
     */
    private void checkCustomerParams(Integer cusId, String linkName, String officePhone, String phone, String zhiwei, String sex) {
        AssertUtil.isTrue(null==cusId,"系统异常,没有选择客户");
        AssertUtil.isTrue(StringUtils.isBlank(linkName),"联系人不可为空");
        AssertUtil.isTrue(StringUtils.isBlank(officePhone),"请输入办公电话");
        AssertUtil.isTrue(StringUtils.isBlank(phone),"请输入联系电话");
        AssertUtil.isTrue(StringUtils.isBlank(zhiwei),"请选择职位");
        AssertUtil.isTrue(StringUtils.isBlank(sex)||!("男".equals(sex)) && !("女".equals(sex)),"请选择性别【男/女】");
    }


}
