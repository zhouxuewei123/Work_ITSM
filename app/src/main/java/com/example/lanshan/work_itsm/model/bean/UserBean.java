package com.example.lanshan.work_itsm.model.bean;

import java.io.Serializable;

/**
 * Created by lanshan on 2017/9/19.
 */

public class UserBean implements Serializable {

    /**
     * account : Administrator
     * token : MDEeaOdGnqg87yqsS3ESGMwWlzMj40LRIlRY+og8F3gvHQO9K/ogga/P
     * success : true
     * realUsername : 管理员
     */

    private String account;
    private String token;
    private boolean success;
    private String realUsername;
    private String password;
    private String exception;

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getRealUsername() {
        return realUsername;
    }

    public void setRealUsername(String realUsername) {
        this.realUsername = realUsername;
    }
}
