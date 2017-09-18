package com.android.core;

import android.app.Application;
import android.content.Context;

import com.android.core.utils.FileUtils;


/**
 * @Description:
 * @author: ragkan
 * @time: 2016/11/1 14:39
 */
public class MainApp extends Application {

    public static String cacheDir = "";
    private static MainApp ourInstance = new MainApp();
    private static Context mContext;

    public static MainApp getInstance() {
        return ourInstance;
    }

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ourInstance = this;
        mContext = getApplicationContext();

        /**
         * 如果存在SD卡则将缓存写入SD卡,否则写入手机内存
         */
        if (getApplicationContext().getExternalCacheDir() != null && FileUtils.isSdcardExist()) {
            cacheDir = getApplicationContext().getExternalCacheDir().toString();
        } else {
            cacheDir = getApplicationContext().getCacheDir().toString();
        }
    }
}
