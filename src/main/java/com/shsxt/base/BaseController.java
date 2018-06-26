package com.shsxt.base;

import com.shsxt.crm.model.ResultInfo;

public class BaseController<T> {

    public ResultInfo<T> success(String msg){
        ResultInfo<T> resultInfo=new ResultInfo<>();
        resultInfo.setMsg(msg);
        return resultInfo;
    }

    public ResultInfo<T> success(String msg,Object result){
        ResultInfo<T> resultInfo=new ResultInfo<>();
        resultInfo.setMsg(msg);
        resultInfo.setResult(result);
        return resultInfo;
    }

    public ResultInfo<T> success(Object result){
        ResultInfo<T> resultInfo=new ResultInfo<>();
        resultInfo.setResult(result);
        return resultInfo;
    }


}
