package com.example.lanshan.work_itsm.present;

import com.android.core.model.annotation.Implement;

/**
 * Created by lanshan on 2017/9/19.
 */
@Implement(LoginPresenter.class)
public interface ILogin {
    void login(String username,String password);
}
