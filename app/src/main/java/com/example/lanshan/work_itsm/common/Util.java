package com.example.lanshan.work_itsm.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.MainApplication;
import com.android.core.utils.Utils;

import com.example.lanshan.work_itsm.model.config.Const;
import com.google.gson.reflect.TypeToken;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @Description:
 * @author: ragkan
 * @time: 2016/07/14 12:16
 */
public class Util {

    public static int getIndex(String[] array, String value) {
        int index = 0;
        for (String str : array) {
            if (str.equals(value)) {
                break;
            }
            index++;
        }
        return index;
    }

    public static String getResultByException(Throwable t) {
        if (t instanceof java.net.SocketTimeoutException) {
            return "连接网络超时";
        }
        if (t instanceof java.net.ConnectException) {
            return "连接服务器失败";
        }
        return t.getMessage();
    }

    /**
     * 只关注是否联网
     *
     * @return
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager mConnectivityManager = (ConnectivityManager) MainApplication.getContext().getSystemService(MainApplication.getContext().CONNECTIVITY_SERVICE);
        NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
        if (mNetworkInfo != null) {
            return mNetworkInfo.isAvailable();
        }
        return false;
    }

    public static String sHA1(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), PackageManager.GET_SIGNATURES);
            byte[] cert = info.signatures[0].toByteArray();
            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] publicKey = md.digest(cert);
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < publicKey.length; i++) {
                String appendString = Integer.toHexString(0xFF & publicKey[i])
                        .toUpperCase(Locale.US);
                if (appendString.length() == 1)
                    hexString.append("0");
                hexString.append(appendString);
                hexString.append(":");
            }
            return hexString.toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断GPS是否开启，GPS或者AGPS开启一个就认为是开启的
     *
     * @param context
     * @return true 表示开启
     */
    public static final boolean isOPen(final Context context) {
        LocationManager locationManager = (LocationManager) context
                .getSystemService(Context.LOCATION_SERVICE);
        // 通过GPS卫星定位，定位级别可以精确到街（通过24颗卫星定位，在室外和空旷的地方定位准确、速度快）
        boolean gps = locationManager
                .isProviderEnabled(LocationManager.GPS_PROVIDER);
        // 通过WLAN或移动网络(3G/2G)确定的位置（也称作AGPS，辅助GPS定位。主要用于在室内或遮盖物（建筑群或茂密的深林等）密集的地方定位）
        boolean network = locationManager
                .isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        if (gps || network) {
            return true;
        }
//        if (gps) {
//            return true;
//        }

        return false;
    }

    /**
     * 强制帮用户打开GPS
     *
     * @param context
     */
    public static final void openGPS(Context context) {
        Intent GPSIntent = new Intent();
        GPSIntent.setClassName("com.android.settings",
                "com.android.settings.widget.SettingsAppWidgetProvider");
        GPSIntent.addCategory("android.intent.category.ALTERNATIVE");
        GPSIntent.setData(Uri.parse("custom:3"));
        try {
            PendingIntent.getBroadcast(context, 0, GPSIntent, 0).send();
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
        // 进入GPS设置页面
//        Intent intent = new Intent();
//        intent.setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        try {
//            context.startActivity(intent);
//        } catch (ActivityNotFoundException ex) {
//            // The Android SDK doc says that the location settings activity
//            // may not be found. In that case show the general settings.
//            // General settings activity
//            intent.setAction(Settings.ACTION_SETTINGS);
//            try {
//                context.startActivity(intent);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }

//    public static boolean saveLocalDate(String newParam) {
//        boolean flag = false;
//        String uploadJS = MainApplication.aCache.getAsString(Const.ACACHE_UPLOAD_JS);
//        List<String> cacheDates = new ArrayList<>();
//        if (!Utils.isEmpty(uploadJS)) {
//            List<String> date = MainApplication.gson.fromJson(uploadJS, new TypeToken<List<String>>() {
//            }.getType());
//            cacheDates.addAll(date);
//
//            JobSlip newJS = AndroidApp.gson.fromJson(newParam, JobSlip.class);
//
//            for (String jsStr : cacheDates) {
//                JobSlip js = AndroidApp.gson.fromJson(jsStr, JobSlip.class);
//                if (js.getId().equals(newJS.getId())) {
//                    flag = true;
//                    break;
//                }
//            }
//        }
//
//        if (!flag) {
//            Log.i("uploadJS", "缓存数据");
//            cacheDates.add(newParam);
//            MainApplication.aCache.put(Const.ACACHE_UPLOAD_JS, MainApplication.gson.toJson(cacheDates));
//            return true;
//        }
//
//        return false;
//    }

    public static int getNetWorkType(Context context) {
        // 获得网络连接服务
        ConnectivityManager connManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo info = connManager.getActiveNetworkInfo();

        return info.getType();
    }

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        Log.i("height", result + "");
        return result;
    }

//    public static void openNFC(Activity activity) {
//        Intent intent = new Intent("android.settings.NFC_SETTINGS");// Settings.ACTION_NFC_SETTINGS
//        activity.startActivityForResult(intent, 1);
//    }

//    public static AlertDialog showScanCardTip(Context context) {
//        View view = LayoutInflater.from(context).inflate(R.layout.activity_dialog_card_login, null);
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(context)
//                .setView(view);
////                .setCancelable(true)
////                .setNegativeButton("关闭", null);
//
//        return builder.create();
//    }

    public static boolean isToday() {
        String mNow = Utils.getCurformatDate(Const.dateFormate3);
        Date nowDate = Utils.string2date(mNow, Const.dateFormate3);
        long nowTime = nowDate.getTime();
        String EndDate = Utils.getCurformatDate("yyyy-MM-dd") + " 20:00:00";
        String StartDate = Utils.getCurformatDate("yyyy-MM-dd") + " 08:00:00";
        Date mEndDate = Utils.string2date(EndDate, Const.dateFormate3);
        Date mStartDate = Utils.string2date(StartDate, Const.dateFormate3);
        long endTime = (Utils.string2date(Utils.formatTime(mEndDate, Const.dateFormate3), Const.dateFormate3)).getTime();
        long startTime = (Utils.string2date(Utils.formatTime(mStartDate, Const.dateFormate3), Const.dateFormate3)).getTime();
        if (nowTime > startTime && nowTime < endTime) {
            return true;
        } else {
            return false;
        }
    }

    //过滤掉时间，将年月日的时期设置为最小值，否则会报错
    public static long getOnlyTime(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = new Date(time);
        String t1 = format.format(d1);
        return Utils.string2date(t1, "yyyy-MM-dd").getTime();
    }

}
