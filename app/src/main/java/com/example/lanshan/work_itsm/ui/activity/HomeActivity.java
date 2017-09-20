package com.example.lanshan.work_itsm.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.MainApplication;
import com.android.core.ui.BaseActivity;
import com.example.lanshan.work_itsm.R;
import com.example.lanshan.work_itsm.model.bean.UserBean;
import com.example.lanshan.work_itsm.model.config.Const;
import com.example.lanshan.work_itsm.ui.fragment.LeftSlideFragment;
import com.google.gson.reflect.TypeToken;
import com.zhy.autolayout.AutoLinearLayout;

import butterknife.Bind;

/**
 * Created by lanshan on 2017/9/20.
 * 主菜单页面
 */

public class HomeActivity extends BaseActivity implements View.OnClickListener{
    @Bind(R.id.drawer_layout)
    DrawerLayout drawer_layout;
    @Bind(R.id.fly_content)
    FrameLayout fly_content;
    @Bind(R.id.ivSlide)
    ImageView ivSlide;//弹出侧滑菜单按钮
    @Bind(R.id.tvUser)
    TextView tvUser;//用户名
    @Bind(R.id.llTodoOrder)
    AutoLinearLayout llTodoOrder;//待办工单
    @Bind(R.id.llCompleteOrder)
    AutoLinearLayout llCompleteOrder;//已办工单
    @Bind(R.id.llStatistic)
    AutoLinearLayout llStatistic;//工单统计
    @Bind(R.id.llScan)
    AutoLinearLayout llScan;//配置扫描
    @Bind(R.id.llQuery)
    AutoLinearLayout llQuery;//知识查询
    @Bind(R.id.llPolling)
    AutoLinearLayout llPolling;//巡检管理
    public LeftSlideFragment fg_left_menu;//侧滑菜单
    public FragmentManager fManager;
    UserBean user;
    @Override
    protected boolean isExistToolbar() {
        return false;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_home;
    }

    @Override
    protected void onInitView() {
        user = MainApplication.gson.fromJson(aCache.getAsString(Const.ACACHE_USER), new TypeToken<UserBean>() {
        }.getType());
        fManager = getSupportFragmentManager();
        fg_left_menu = (LeftSlideFragment) fManager.findFragmentById(R.id.fg_left_menu);
        tvUser.setText(user.getRealUsername());
        ivSlide.setOnClickListener(this);
        llTodoOrder.setOnClickListener(this);
        llCompleteOrder.setOnClickListener(this);
        llStatistic.setOnClickListener(this);
        llScan.setOnClickListener(this);
        llQuery.setOnClickListener(this);
        llPolling.setOnClickListener(this);
        init();

    }

    private void init() {
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED,
                Gravity.END);

        drawer_layout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View view, float v) {

            }

            @Override
            public void onDrawerOpened(View view) {

            }

            @Override
            public void onDrawerClosed(View view) {
//                drawer_layout.setDrawerLockMode(
//                        DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.START);
            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });

        fg_left_menu.setDrawerLayout(drawer_layout,user.getRealUsername());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivSlide:
                drawer_layout.openDrawer(Gravity.LEFT);
                drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED,
                        Gravity.START);    //解除锁定
                break;
            case R.id.llTodoOrder:
                break;
            case R.id.llCompleteOrder:
                break;
            case R.id.llStatistic:
                break;
            case R.id.llScan:
                break;
            case R.id.llQuery:
                break;
            case R.id.llPolling:
                break;
        }
    }
}
