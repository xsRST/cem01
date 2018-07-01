package com.shsxt.crm.interceptors;

import com.shsxt.crm.constant.CrmConstant;
import com.shsxt.crm.service.UserService;
import com.shsxt.crm.utils.AssertUtil;
import com.shsxt.crm.utils.LoginUserUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * @author 殇丶无求
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Resource
    private UserService userService;

    /**
     * 方法执行前拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 判断cookie中用户id是否存在
         */
        Integer id=LoginUserUtil.releaseUserIdFromCookie(request);
        request.setAttribute("ctx",request.getContextPath());
        AssertUtil.isNotLogin(null==id||null==userService.selectById(id),CrmConstant.NOT_LOGIN_MSG);
        return true;
    }
}
