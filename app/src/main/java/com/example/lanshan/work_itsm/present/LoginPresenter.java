package com.example.lanshan.work_itsm.present;



import com.MainApplication;
import com.example.lanshan.work_itsm.R;
import com.example.lanshan.work_itsm.common.Util;
import com.example.lanshan.work_itsm.http.Factory;
import com.example.lanshan.work_itsm.model.bean.UserBean;
import com.example.lanshan.work_itsm.present.presenter.LoadPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Description: 登录验证逻辑
 * @author: ragkan
 * @time: 2016/7/5 14:21
 */
public class LoginPresenter extends LoadPresenter implements ILogin {
    @Override
    public void login(String username, String password) {
        if (!Util.isNetworkConnected()) {
            onLoadFail(MainApplication.getContext().getString(R.string.app_no_network_tip));
            return;
        }

        Factory.provideHttpService().login(username, password).enqueue(new Callback<UserBean>() {
            @Override
            public void onResponse(Call<UserBean> call, Response<UserBean> response) {
                onLoadSuccessResponse(response);
            }

            @Override
            public void onFailure(Call<UserBean> call, Throwable t) {
                onLoadFail(Util.getResultByException(t));
            }
        });
    }
}
