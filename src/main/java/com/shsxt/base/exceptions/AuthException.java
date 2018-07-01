package com.shsxt.base.exceptions;

import com.shsxt.crm.constant.CrmConstant;

/**
 * @author 殇丶无求
 */
public class AuthException extends RuntimeException{
    private Integer errorCode=CrmConstant.NOT_LOGIN_CODE;
    private String errorMsg=CrmConstant.NOT_LOGIN_MSG;

    public AuthException() {
    }

    public AuthException(Integer errorCode) {
        super("操作失败");
        this.errorCode = errorCode;
    }

    public AuthException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
