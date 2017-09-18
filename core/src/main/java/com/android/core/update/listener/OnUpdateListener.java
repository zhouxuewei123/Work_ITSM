package com.android.core.update.listener;

import com.android.core.update.pojo.UpdateInfo;

/**
 *
 * @author ragkan
 * @time 2016/9/21 10:21
 */
public interface OnUpdateListener {
    /**
     * on start check
     */
    public void onStartCheck();

    /**
     * on finish check
     */
    public void onFinishCheck(UpdateInfo info);

    public void onStartDownload();
    
    public void onDownloading(int progress);
    
    public void onFinshDownload();

    public void onInstallApk();
}
