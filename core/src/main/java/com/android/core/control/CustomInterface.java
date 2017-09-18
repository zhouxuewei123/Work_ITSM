package com.android.core.control;

import android.support.v4.view.PagerAdapter;

/**
 * @Description:
 * @author: ragkan
 * @time: 2016/11/1 14:36
 */
public interface CustomInterface {
    void updateIndicatorView(int size, int resid);

    void setAdapter(PagerAdapter adapter);

    void startScorll();

    void endScorll();
}
