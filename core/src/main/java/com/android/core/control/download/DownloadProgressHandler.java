package com.android.core.control.download;


import android.os.Looper;
import android.os.Message;

/**
 * @Description:
 * @author: ragkan
 * @time: 2016/7/27 14:02
 */
public abstract class DownloadProgressHandler extends ProgressHandler{

    private static final int DOWNLOAD_PROGRESS = 1;
    protected ResponseHandler mHandler = new ResponseHandler(this, Looper.getMainLooper());

    @Override
    protected void sendMessage(ProgressBean progressBean) {
        mHandler.obtainMessage(DOWNLOAD_PROGRESS,progressBean).sendToTarget();

    }

    @Override
    protected void handleMessage(Message message){
        switch (message.what){
            case DOWNLOAD_PROGRESS:
                ProgressBean progressBean = (ProgressBean)message.obj;
                onProgress(progressBean.getBytesRead(),progressBean.getContentLength(),progressBean.isDone());

        }
    }


}
