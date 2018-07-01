package com.shsxt.crm.utils;

import com.shsxt.base.exceptions.AuthException;
import com.shsxt.base.exceptions.ParamException;

/**
 * 断言
 * @author 殇丶无求
 */
public class AssertUtil {
    public static void isTrue(Boolean flag,String msg){
        if(flag){
            throw new ParamException(msg);
        }
    }
    public static void isTrue(Boolean flag,Integer code,String msg){
        if(flag){
            throw new ParamException(code,msg);
        }
    }


    public static void isNotLogin(Boolean flag,String msg) {
        if(flag){
            throw new AuthException(msg);
        }
    }
}
