package com.android.core.control.logcat;

import android.util.Log;

/**
 * @Description:
 * @author: ragkan
 * @time: 2016/11/1 14:36
 */
public class AndroidLogTool implements LogTool{

    public AndroidLogTool() {
    }

    public void d(String tag, String message) {
        Log.d(tag, message);
    }

    public void e(String tag, String message) {
        Log.e(tag, message);
    }

    public void w(String tag, String message) {
        Log.w(tag, message);
    }

    public void i(String tag, String message) {
        Log.i(tag, message);
    }

    public void v(String tag, String message) {
        Log.v(tag, message);
    }

    public void wtf(String tag, String message) {
        Log.wtf(tag, message);
    }
}
