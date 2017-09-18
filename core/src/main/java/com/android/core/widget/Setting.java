package com.android.core.widget;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.core.MainApp;

/**
 * @Description: 
 * @author: ragkan
 * @time: 2016/11/1 14:39
 */
public class Setting {

    public static final String CLEAR_CACHE = "clear_cache";//清空缓存
    public static final String HOUR = "小时";//当前小时
    public static final String AUTO_UPDATE = "change_update_time"; //自动更新时长

    public static int ONE_HOUR = 3600;

    private static Setting sInstance;

    private SharedPreferences mPrefs;


    public static Setting getInstance() {
        if (sInstance == null) {
            sInstance = new Setting(MainApp.getContext());
        }
        return sInstance;
    }


    private Setting(Context context) {
        mPrefs = context.getSharedPreferences("setting", Context.MODE_PRIVATE);
        //mPrefs.edit().putInt(CHANGE_ICONS, 1).apply();
    }


    public Setting putBoolean(String key, boolean value) {
        mPrefs.edit().putBoolean(key, value).apply();
        return this;
    }


    public boolean getBoolean(String key, boolean def) {
        return mPrefs.getBoolean(key, def);
    }


    public Setting putInt(String key, int value) {
        mPrefs.edit().putInt(key, value).apply();
        return this;
    }


    public int getInt(String key, int defValue) {
        return mPrefs.getInt(key, defValue);
    }


    public Setting putString(String key, String value) {
        mPrefs.edit().putString(key, value).apply();
        return this;
    }


    public String getString(String key, String defValue) {
        return mPrefs.getString(key, defValue);
    }
}
