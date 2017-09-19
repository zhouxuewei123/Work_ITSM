package com.example.lanshan.work_itsm.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.core.ui.BaseActivity;
import com.android.core.utils.Utils;
import com.example.lanshan.work_itsm.R;
import com.example.lanshan.work_itsm.model.bean.UserBean;
import com.example.lanshan.work_itsm.model.config.Const;
import com.example.lanshan.work_itsm.present.ILogin;
import com.example.lanshan.work_itsm.present.LoginPresenter;
import com.example.lanshan.work_itsm.present.core.LoadView;

import butterknife.Bind;

/**
 * Created by lanshan on 2017/9/19.
 */

public class LoginActivity extends BaseActivity implements LoadView<UserBean>,View.OnClickListener {
    @Bind(R.id.etUsername)
    EditText etUsername;
    @Bind(R.id.etPassword)
    EditText etPassword;
    @Bind(R.id.btLogin)
    Button btLogin;
    @Bind(R.id.ivList)
    ImageView ivList;
    @Override
    protected boolean isExistToolbar() {
        return false;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void onInitView() {
        mPresenter = getLogicImpl(ILogin.class, this);
        final UserBean user = (UserBean) aCache.getAsObject(Const.ACACHE_USER);
        if (user != null) {
            etUsername.setText(user.getAccount());
            etPassword.setText(user.getPassword());
        }
        btLogin.setOnClickListener(this);
    }

    @Override
    public void onLoadComplete(boolean result) {
        hideLoadView();
    }

    @Override
    public void onLoadSuccessResponse(UserBean body) {
        hideLoadView();
        if(body!=null){
            if(body.isSuccess()){
                showShortToast("登录成功");
            }else {
                if(!Utils.isEmpty(body.getException())){
                    showShortToast(body.getException());
                }else {
                    showShortToast("登录失败，请重新登录");
                }
            }
        }else {
            showShortToast("登录失败，请重新登录");
        }

    }

    @Override
    public void onFailure(String msg) {
        hideLoadView();
        showShortToast(msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btLogin:
                login();
                break;
        }
    }

    private void login() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        if(Utils.isEmpty(username)){
            showShortToast("账号不能为空");
            return;
        }
        if(Utils.isEmpty(password)){
            showShortToast("密码不能为空");
            return;
        }
        showLoadView(getString(R.string.login_loading));
        ((LoginPresenter) mPresenter).login(username, password);
    }
}
