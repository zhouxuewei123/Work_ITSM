package com.android.core.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.core.model.control.BasePresenter;
import com.android.core.model.control.LogicProxy;
import com.android.core.model.control.BaseView;
import com.android.core.widget.LoadingView;

import butterknife.ButterKnife;

/**
 * @Description: 
 * @author: ragkan
 * @time: 2016/11/1 14:38
 */
public abstract class BaseFragment extends Fragment {
    protected View rootView;
    private LoadingView mLoginView;
    protected BasePresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null)
            rootView = inflater.inflate(getLayoutResource(), container, false);
        ButterKnife.bind(this, rootView);
        mLoginView = new LoadingView(getActivity());
        onInitView();
        return rootView;
    }

    protected abstract int getLayoutResource();

    protected abstract void onInitView();

    public void showLoadingView() {
        mLoginView.show();
    }

    public void hideLoadingView() {
        mLoginView.hide();
    }

    //获得该页面的实例
    public <T> T getLogicImpl(Class cls, BaseView o) {
        return LogicProxy.getInstance().bind(cls, o);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        if (mPresenter != null)
            mPresenter.detachView();
    }

}
