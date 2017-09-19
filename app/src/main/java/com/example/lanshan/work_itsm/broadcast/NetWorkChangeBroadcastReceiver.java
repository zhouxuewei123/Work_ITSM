package com.example.lanshan.work_itsm.broadcast;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.MainApplication;
import com.android.core.utils.Utils;

import com.example.lanshan.work_itsm.common.Util;
import com.example.lanshan.work_itsm.model.config.Const;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class NetWorkChangeBroadcastReceiver extends BroadcastReceiver {
    private static int lastType = -1;
    private static AlertDialog ad;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Tag", "网络状态改变 action=" + intent.getAction() + " lastType="
                + lastType);
        boolean flag = Util.isNetworkConnected();
        if (flag) {
            int netType = Util.getNetWorkType(context);
            if (lastType != netType) {
                Log.i("最后一次网络连接", netType + "");
                lastType = netType;
                uploadJSApprove();
            }
        } else {
            // 当前网络已断开
            // 可能接收到多次相同的广播，暂时没有找到原因，所以判断对话框来解决多次弹出的问题；
            lastType = -1;
        }
        // abortBroadcast();
    }

    /**
     * 若有网络时，上传缓存的审批信息，上传之后删除
     **/
    private void uploadJSApprove() {
        Log.i("uploadJS", "网络可用,提交缓存的数据");
        String uploadJS = MainApplication.aCache.getAsString(Const.ACACHE_UPLOAD_JS);
        if (Utils.isEmpty(uploadJS)) {
            return;
        }
        List<String> dates = MainApplication.gson.fromJson(uploadJS, new TypeToken<List<String>>() {
        }.getType());

        for (int i = dates.size() - 1; i >= 0; i--) {
            Log.i("uploadJS", "提交缓存数据" + i);
            if (Utils.isEmpty(dates.get(i))) {
                continue;
            }
//            MainApplication.uploadJSApprove(dates.get(i), dates, i);
        }
    }
}
