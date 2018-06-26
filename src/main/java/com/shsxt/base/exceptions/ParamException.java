package com.shsxt.base.exceptions;

/**
 * 参数错误
 */
public class ParamException extends RuntimeException{

    private Integer erroCode=300;
    private String erroMsg="操作失败";

    public ParamException() {
    }

    public ParamException(Integer erroCode) {
        super("操作失败!");
        this.erroCode = erroCode;
    }

    public ParamException(String erroMsg) {
        this.erroMsg = erroMsg;
    }

    public ParamException(Integer erroCode, String erroMsg) {
        this.erroCode = erroCode;
        this.erroMsg = erroMsg;
    }

    public Integer getErroCode() {
        return erroCode;
    }

    public void setErroCode(Integer erroCode) {
        this.erroCode = erroCode;
    }

    public String getErroMsg() {
        return erroMsg;
    }

    public void setErroMsg(String erroMsg) {
        this.erroMsg = erroMsg;
    }
}
