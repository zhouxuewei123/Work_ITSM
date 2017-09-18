package com.android.core.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.core.R;
import com.android.core.control.logcat.Logcat;
import com.android.core.model.control.BasePresenter;
import com.android.core.model.control.BaseView;
import com.android.core.model.control.LogicProxy;
import com.android.core.utils.ACache;
import com.android.core.widget.LoadingView;
import com.android.core.widget.Setting;
import com.android.core.widget.ToastView;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.io.Serializable;

import butterknife.ButterKnife;


/**
 * @Description: BaseActivity
 * @author: ragkan
 * @time: 2016/7/6 22:29
 */
public abstract class BaseActivity extends AppCompatActivity {

    private LoadingView mLoadingView;
    protected BasePresenter mPresenter;
    TextView tvToolbarTitle;
    public Toolbar toolbar;
    public LinearLayout rootLayout;
    public ACache aCache;
    public Setting mSetting = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logcat.d("Activity Location (%s.java:0)", getClass().getSimpleName());
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // 这句很关键，注意是调用父类的方法
        if (isExistToolbar()) {
            super.setContentView(R.layout.activity_base);

            rootLayout = (LinearLayout) findViewById(R.id.root_layout);
            if (rootLayout == null) return;
            View Content = LayoutInflater.from(this).inflate(getLayoutResource(), (ViewGroup) findViewById(android.R.id.content), false);
            rootLayout.addView(Content, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            tvToolbarTitle = (TextView) findViewById(R.id.tvToolbarTitle);
            setToolbar();
            setSupportActionBar(toolbar);
        } else if (getLayoutResource() != 0) {
            setContentView(getLayoutResource());
        }
        // 经测试在代码里直接声明透明状态栏更有效
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        Log.i("init", this.toString());
        ButterKnife.bind(this);
        mLoadingView = new LoadingView(this);
        mLoadingView.setMessage("正在加载...");
        aCache = ACache.get(BaseActivity.this);
        mSetting = Setting.getInstance();

        onInitView();
    }

    protected void setToolbar() {

        if (toolbar != null) {
            toolbar.setContentInsetsRelative(0, 0);
            toolbar.setTitle("");
            final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
            upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
            toolbar.setNavigationIcon(upArrow);
        }
    }

//    public void initToolBar(Toolbar toolbar) {
//        toolbar.setContentInsetsRelative(0, 0);
//        toolbar.setTitle("");
//        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
//        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
//        toolbar.setNavigationIcon(upArrow);
//        tvTitle = (TextView) toolbar.findViewById(R.id.tvTitle);
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //点击有上角箭头，关闭当前页面
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setTitle(String title) {
        tvToolbarTitle.setText(title);
    }

    protected abstract boolean isExistToolbar();

    protected abstract int getLayoutResource();

    protected abstract void onInitView();

//    @Override
//    public void startActivity(Intent intent) {
//        super.startActivity(intent);
//        // 打开Activity动画
//    }

    public void showLoadView() {
        //Log.i("showLoadView",this.toString());
        if (!mLoadingView.getMessage().equals("正在加载...")) {
            mLoadingView.setMessage("正在加载...");
        }
        mLoadingView.show();
    }

    public void showLoadView(String mes) {
        //Log.i("showLoadView",this.toString());
        mLoadingView.setMessage(mes).show();
    }

    public void hideLoadView() {
        //Log.i("hideLoadView",this.toString());
        mLoadingView.dismiss();
    }

//    public void hideLoadView(String mes) {
//        //Log.i("hideLoadView",this.toString());
//        mLoadingView.setMessage(mes).dismiss();
//    }

    //获得该页面的实例
    public <T> T getLogicImpl(Class cls, BaseView o) {
        return LogicProxy.getInstance().bind(cls, o);
    }

    @Override
    public void finish() {
        super.finish();
        // 关闭动画
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        Log.i("destroy", this.toString());
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        if (mLoadingView != null && mLoadingView.isShowing()) {
            mLoadingView.dismiss();
        }
    }

    /**
     * 设置状态栏颜色
     * 也就是所谓沉浸式状态栏
     */
    public void setStatusBarColor(int color) {
        /**
         * Android4.4以上  但是抽屉有点冲突，目前就重写一个方法暂时解决4.4的问题
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(color);
        }
    }


    public void setStatusBarColorForKitkat(int color) {
        /**
         * Android4.4
         */
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(color);
        }
    }

    /**
     * 短暂显示Toast提示(来自res)
     *
     * @param resId
     */
    public void showShortToast(int resId) {
        // Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show();
        ToastView.showToast(this, getString(resId), Toast.LENGTH_SHORT);
    }

    /**
     * 短暂显示Toast提示(来自String)
     *
     * @param text
     */
    public void showShortToast(String text) {
        // Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        ToastView.showToast(this, text, Toast.LENGTH_SHORT);
    }

    /**
     * 长时间显示Toast提示(来自res)
     *
     * @param resId
     */
    public void showLongToast(int resId) {
        // Toast.makeText(this, getString(resId), Toast.LENGTH_LONG).show();
        ToastView.showToast(this, getString(resId), Toast.LENGTH_LONG);
    }

    /**
     * 长时间显示Toast提示(来自String)
     *
     * @param text
     */
    public void showLongToast(String text) {
        // Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        ToastView.showToast(this, text, Toast.LENGTH_LONG);
    }

    /***************************
     * 跳转界面
     ***********************************/
    public void skip(Class<? extends Activity> cls) {
//        if (!AppUtils.checkNet(activity)) {
//            activity.toast(activity.getResources().getString(
//                    R.string.internet_error));
//            return;
//        }
        startActivity(new Intent(this, cls));
    }

    public void skip(String action) {
//        if (!AppUtils.checkNet(activity)) {
//            activity.toast(activity.getResources().getString(
//                    R.string.internet_error));
//            return;
//        }
        startActivity(new Intent(action));
    }

    public void skip(String action, Serializable... serializ) {
//        if (!AppUtils.checkNet(activity)) {
//            activity.toast(activity.getResources().getString(
//                    R.string.internet_error));
//            return;
//        }
        Intent intent = new Intent(action);
        Bundle extras = new Bundle();
        for (int i = 0; i < serializ.length; i++) {
            Serializable s = serializ[i];
            // 放对象的规则，以顺序为键
            extras.putSerializable(i + "", s);
        }
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void skip(Class<? extends Activity> cls, Serializable... serializ) {
//        if (!AppUtils.checkNet(activity)) {
//            activity.toast(activity.getResources().getString(
//                    R.string.internet_error));
//            return;
//        }
        Intent intent = new Intent(this, cls);
        Bundle extras = new Bundle();
        for (int i = 0; i < serializ.length; i++) {
            Serializable s = serializ[i];
            // 放对象的规则，以顺序为键
            extras.putSerializable(i + "", s);
        }
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void skipForResult(Class<? extends Activity> cls, int requestCode, Serializable... serializ) {
        Intent intent = new Intent(this, cls);
        Bundle extras = new Bundle();
        for (int i = 0; i < serializ.length; i++) {
            Serializable s = serializ[i];
            // 放对象的规则，以顺序为键
            extras.putSerializable(i + "", s);
        }
        intent.putExtras(extras);
        startActivityForResult(intent, requestCode);
    }
}
