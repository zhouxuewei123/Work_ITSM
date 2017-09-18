package com.android.core.model.control;

/**
 * @Description:
 * @author: ragkan
 * @time: 2016/11/1 14:37
 */
public interface Presenter<V> {
    void attachView(V mvpView);
    void detachView();
}
