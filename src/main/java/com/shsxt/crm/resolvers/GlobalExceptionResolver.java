package com.shsxt.crm.resolvers;

import com.alibaba.fastjson.JSON;
import com.shsxt.base.exceptions.AuthException;
import com.shsxt.base.exceptions.ParamException;
import com.shsxt.crm.model.ResultInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * 异常统一处理,
 */
@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        /**
         * 异常分类处理
         * 错误视图
         * json异常
          */
        //1.登录异常

        if(ex instanceof AuthException){
            ModelAndView mv=getDefaultModelAndView();
            mv.setViewName("not_login");
            mv.addObject("ctx",request.getContextPath());
            mv.addObject("msg",((AuthException) ex).getErrorMsg());
            /*
                可能会出现 登录页面被包含在主页面
                设置访问的uri
             */
            mv.addObject("uri",request.getRequestURI());
            return mv;
        }
        //通过方法上的注解 得知返回类型是视图还是json文件
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod= (HandlerMethod) handler;
            Method method=handlerMethod.getMethod(); //获取目标方法
            ResponseBody  requestBody=method.getAnnotation(ResponseBody.class);
            if(null!=requestBody){
                /**
                 * 不为空,返回类型是json类型
                 */
                ResultInfo resultInfo=new ResultInfo();
                //设置默认错误信息
                resultInfo.setCode(300);
                resultInfo.setMsg("操作失败!");
                //异常分析
                //参数异常
                if(ex instanceof ParamException){
                    ParamException pe= (ParamException) ex;
                    resultInfo.setCode(pe.getErroCode());
                    resultInfo.setMsg(pe.getErroMsg());
                }
                /**
                 * 将resultInfo对象写出到浏览器,格式为JSON
                 */
                response.setCharacterEncoding("utf-8");
                response.setContentType("application/json;charset=utf-8");
                PrintWriter pw= null;
                try {
                    pw = response.getWriter();
                    pw.write(JSON.toJSONString(resultInfo));
                    pw.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (null!=pw){
                        pw.close();
                    }
                }
                return null;
            }
            else{
                /**
                 * 当前方法返回视图
                 */
                ModelAndView mv=getDefaultModelAndView();
                /*
                    异常分析:
                 */
                //参数异常
                if(ex instanceof ParamException){
                    ParamException px= (ParamException) ex;
                    mv.addObject("code",px.getErroCode());
                    mv.addObject("msg",px.getErroMsg());
                }
                return mv;
            }
        }else{
            return getDefaultModelAndView();
        }

    }

    /**
     * 默认错误视图与错误信息
     * @return
     */
    private ModelAndView getDefaultModelAndView() {
        ModelAndView mv=new ModelAndView("error");
        mv.addObject("code",300);
        mv.addObject("msg","操作失败!");
        return mv;
    }
}
