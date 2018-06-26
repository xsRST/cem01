package com.shsxt.crm.service;

import com.shsxt.base.BaseService;
import com.shsxt.crm.dao.UserDao;
import com.shsxt.crm.model.UserModel;
import com.shsxt.crm.query.UserQuery;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.utils.Md5Util;
import com.shsxt.crm.utils.UserIDBase64;
import com.shsxt.crm.vo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService extends BaseService<User> {

    @Resource
    private UserDao userDao;

    /**
     * 登录操作:
     *  参数校验
     *  执行查询,返回结果
     *  判断结果
     *  返回用户信息
     *
     */
    public UserModel loginCheck(UserQuery userQuery){
       checkLoginParams(userQuery.getUserName(),userQuery.getUserPwd());
       User user=userDao.selectByName(userQuery.getUserName());
       AssertUtil.isTrue(null==user,"用户记录不存在");
       userQuery.setUserPwd(Md5Util.encode(userQuery.getUserPwd()));
       AssertUtil.isTrue(!(user.getUserPwd().equals(userQuery.getUserPwd())),"密码不正确");
       return buildUserInfo(user);
    }

    /**
     * 修改密码
     * @param userId
     * @param oldPassword
     * @param newPassword
     * @param confirmPassword
     */
    public  void updateUserPassword(Integer userId, String oldPassword, String newPassword, String confirmPassword){
        //校验参数
        checkModifyPasswordParams(userId,oldPassword,newPassword,confirmPassword);
        //调用dao层 执行查询结果
        User user=userDao.selectById(userId);
        user.setUserPwd(Md5Util.encode(newPassword));
        AssertUtil.isTrue(userDao.update(user)<1,"密码更新失败");
    }

    /**
     * 校验修改密码的 id,新密码,旧密码,确认密码
     * @param userId
     * @param oldPassword
     * @param newPassword
     * @param confirmPassword
     */
    private void checkModifyPasswordParams(Integer userId, String oldPassword, String newPassword, String confirmPassword) {
        User user=userDao.selectById(userId);
        AssertUtil.isTrue(null==userId||null==user,"用户未登录");
        AssertUtil.isTrue(StringUtils.isBlank(oldPassword),"原始密码为空");
        AssertUtil.isTrue(StringUtils.isBlank(newPassword),"新密码为空");
        AssertUtil.isTrue(StringUtils.isBlank(confirmPassword),"确认密码为空");
        AssertUtil.isTrue(!(newPassword.equals(confirmPassword)),"密码不一致");
        AssertUtil.isTrue(!(user.getUserPwd().equals(Md5Util.encode(oldPassword))),"原始密码不正确");

    }

    /**
     * 构建用户信息:加密id
     * @param user
     * @return
     */
    private UserModel buildUserInfo(User user) {
        //id加密
        UserModel userModel=new UserModel();
        userModel.setId(UserIDBase64.encoderUserID(user.getId()));
        userModel.setUserName(user.getUserName());
        userModel.setTrueName(user.getTrueName());
        return userModel;
    }

    /**
     * 校验用户登录参数
     * @param userName
     * @param userPwd
     */
    private void checkLoginParams(String userName, String userPwd) {

        AssertUtil.isTrue(StringUtils.isBlank(userName),"用户名不可为空");
    }


}
