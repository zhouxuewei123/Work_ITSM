package com;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.android.core.MainApp;
import com.android.core.control.logcat.BuildConfig;
import com.android.core.control.logcat.Logcat;
import com.android.core.model.control.LogicProxy;
import com.android.core.utils.ACache;
import com.android.core.utils.FileUtils;
import com.android.core.utils.Utils;
import com.example.lanshan.work_itsm.model.config.Const;
import com.example.lanshan.work_itsm.present.ILogin;
import com.google.gson.Gson;
import com.squareup.leakcanary.RefWatcher;

import java.io.File;

/**
 * Created by lanshan on 2017/9/19.
 */

public class MainApplication extends MainApp {
    public static boolean hasTodoQueryName = false;
    public static boolean hasJSQueryName = false;
    public static boolean hasOrderQueryName = false;
    public static boolean hasUserMrgQueryName = false;
    public static boolean isRefreshed = false;
    public static String file_path = "";
    public static String username = null;
    public static ACache aCache = null;
    public static Gson gson = null;
    public static String mDomain = "";
    public static String mMapUrl = "";
    public static String mBaseUrl = "";

    @Override
    public void onCreate() {
        super.onCreate();
        //setMapSHA1();
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.install(this);
//        refWatcher = LeakCanary.install(this);
        aCache = ACache.get(MainApplication.getContext());
        gson = new Gson();

        mDomain = aCache.getAsString(Const.ACacheDomain);
        if (Utils.isEmpty(mDomain)) {
            mDomain = Const.domain;
        }

        mBaseUrl = mDomain;



        LogicProxy.getInstance().init(ILogin.class
             );

        //Android crash 上传服务器回掉
//        HttpReportCallback report = new HttpReportCallback() {
//            @Override
//            public void uploadException2remote(File file) {
//                //直接上传异常文件到服务器
//                FileUpload.uploadCrashText(Const.SERVER_CRASH_PATH, file);
//            }
//        };
//        AndroidCrash.getInstance().setCrashReporter(report).init(this);

        if (BuildConfig.DEBUG) {
            Logcat.init("com.android.logcat").hideThreadInfo().methodCount(3);
        }

//        gps = new GPS(this.getContext());
//        gps.startLocation();
        file_path = FileUtils.getSDPath() + File.separator + Const.fileName;

        // 获取内置存储区目录
        if (!FileUtils.isFileExists(file_path)) {
            FileUtils.createDirFile(file_path);
        }

    }

    //在自己的Application中添加如下代码
    public static RefWatcher getRefWatcher(Context context) {
        MainApplication application = (MainApplication) context
                .getApplicationContext();
        return application.refWatcher;
    }

    //在自己的Application中添加如下代码
    private RefWatcher refWatcher;



    @Override
    public void attachBaseContext(Context base) {
        MultiDex.install(base);
        super.attachBaseContext(base);
    }

    @Override
    public void onTerminate() {
        // 程序终止的时候执行
        Log.i("APP", "onTerminate");
//        gps.setNull();

        super.onTerminate();
    }
}