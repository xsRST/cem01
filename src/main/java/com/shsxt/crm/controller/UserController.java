package com.shsxt.crm.controller;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.ResultInfo;
import com.shsxt.crm.model.UserModel;
import com.shsxt.crm.query.UserQuery;
import com.shsxt.crm.service.UserService;
import com.shsxt.crm.utils.LoginUserUtil;
import com.shsxt.crm.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller

public class UserController extends BaseController<User> {

    @Resource
    private UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public ResultInfo<User> login(UserQuery userQuery){
        UserModel userModel=userService.loginCheck(userQuery);
        return success(userModel);
    }

    @RequestMapping("modifyPassword")
    @ResponseBody
    public ResultInfo<User> modifyPassword(HttpServletRequest request, String oldPassword, String newPassword, String confirmPassword){
        Integer userId=LoginUserUtil.releaseUserIdFromCookie(request);
        userService.updateUserPassword(userId,oldPassword, newPassword,confirmPassword);
        return success("密码修改成功!!");
    }



}
