package com.shsxt.crm.vo;

import com.shsxt.base.BaseModel;

/**
 * 用户
 * @author 殇丶无求
 */
public class User extends BaseModel {

    /**用户账号**/
    private String userName;

    /**用户密码**/
    private String userPwd;

    /**用户真实名称**/
    private String trueName;

    /**邮箱**/
    private String email;

    /**手机号**/
    private String phone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

}