package com.example.lanshan.work_itsm.present.presenter;

import android.widget.Toast;

import com.MainApplication;
import com.android.core.model.control.BasePresenter;
import com.android.core.widget.ToastView;
import com.example.lanshan.work_itsm.present.core.LoadView;


import retrofit2.Response;

/**
 * 加载数据的主导器
 *
 * @Description:
 * @author: ragkan
 * @time: 2016/7/5 14:08
 */
public class LoadPresenter<D> extends BasePresenter<LoadView> {

    public void onLoadSuccessResponse(Response<D> response) {
        if (getView() == null) {
            ToastView.showToast(MainApplication.getContext(), "错误onLoadSuccessResponse[loadView=null]", Toast.LENGTH_SHORT);
            return;
        }

        getView().onLoadComplete(true);

        D body = response.body();
        int code = response.code();
        if (code == 200 && body != null) {
            getView().onLoadSuccessResponse(body);
//            BaseBean baseBean = (BaseBean) body;
//            Object obj = baseBean.getData();
//            if (baseBean.isSuccess()) {
//                if (obj != null) {
//                    getView().onLoadSuccessResponse(obj);
//                } else {//"返回数据出错[请联系管理员]"
//                    ToastView.showToast(MainApplication.getContext(), "暂无数据", Toast.LENGTH_SHORT);
//                }
//            } else {
//                getView().onLoadComplete(false);
//                ToastView.showToast(MainApplication.getContext(), baseBean.getMsg(), Toast.LENGTH_SHORT);
//            }
        } else {
            getView().onLoadComplete(false);
            String result = response.message();
            if (code == 404) {
                result = "服务器地址找不到";
            }
            ToastView.showToast(MainApplication.getContext(), result + "[" + code + "]", Toast.LENGTH_SHORT);
        }
    }

    public void onLoadFail(String msg) {
        if (getView() == null) {
            ToastView.showToast(MainApplication.getContext(), "错误onLoadFail[loadView=null]", Toast.LENGTH_SHORT);
            return;
        }
        //可以选择单独还是统一处理
        getView().onFailure(msg);
    }
}
