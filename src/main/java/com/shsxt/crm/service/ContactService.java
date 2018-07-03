package com.shsxt.crm.service;

import com.github.pagehelper.PageInfo;
import com.shsxt.base.BaseService;
import com.shsxt.crm.dao.ContactDao;
import com.shsxt.crm.query.ContactQuery;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.vo.Contact;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 殇丶无求
 */
@Service
public class ContactService extends BaseService<Contact> {

    @Resource
    private ContactDao contactDao;


    /**
     * 删除客户交往记录
     * @param cusId
     */
    public void deleteContact(Integer cusId) {
        AssertUtil.isTrue(null==cusId,"请选择要删除的客户交往记录");
        AssertUtil.isTrue(contactDao.delete(cusId)<1,"删除失败");
    }
    /**
     * 更新客户联系人
     * @param contact
     */
    public void updateContact(Contact contact) {
        /*
            1基本参数校验:
             客户名称唯一性
               设置其他参数:
                    是否有效
                    更新时间
            2.执行方法
         */
        checkCustomerParams(contact.getId(),contact.getCusId(),contact.getAddress(),contact.getOverview());
        contact.setUpdateDate(new Date());
        AssertUtil.isTrue(contactDao.update(contact)<1,"更新失败");
    }



    /**
     * 添加客户交往记录
     * @param contact
     */
    public void addContact(Contact contact) {
        //保存数据
        checkCustomerParams(contact.getCusId(),contact.getAddress(),contact.getOverview());
        contact.setCreateDate(new Date());
        contact.setUpdateDate(new Date());
        contact.setIsValid(1);
        AssertUtil.isTrue(contactDao.insert(contact)<1,"添加失败");
    }




    /**
     * 查询客户交往记录
     * @param contactQuery
     * @return
     */
    public Map<String,Object> queryByParams(ContactQuery contactQuery) {
        Map<String,Object> map=new HashMap<>(6);
        PageInfo<Contact> pageInfo=queryForPage(contactQuery);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    /**
     * 检验参数
     * @param id
     * @param cusId
     * @param address
     * @param overview
     */
    private void checkCustomerParams(Integer id, Integer cusId, String address, String overview) {
        AssertUtil.isTrue(null==id,"请选择交往记录");
        checkCustomerParams(cusId, address, overview);
    }

    private void checkCustomerParams(Integer cusId, String address, String overview) {

        AssertUtil.isTrue(null==cusId,"请选择客户");
        AssertUtil.isTrue(StringUtils.isBlank(address),"请输入交往地址");
        AssertUtil.isTrue(StringUtils.isBlank(overview),"请输入概要");
    }
}
