package com.example.lanshan.work_itsm.present.core;

import com.android.core.model.control.BaseView;

/**
 * @Description: 加载界面接口
 * @author: ragkan
 * @time: 2016/7/5 14:08
 */
public interface LoadView<T> extends BaseView {
    void onLoadComplete(boolean result);

    void onLoadSuccessResponse(T body);

    void onFailure(String msg);
}
