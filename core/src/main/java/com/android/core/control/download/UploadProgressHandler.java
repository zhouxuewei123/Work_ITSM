package com.android.core.control.download;

import android.os.Looper;
import android.os.Message;

/**
 * @Description:
 * @author: ragkan
 * @time: 2016/7/27 14:03
 */
public abstract class UploadProgressHandler extends ProgressHandler{

    private static final int UPLOAD_PROGRESS = 0;
    protected ResponseHandler mHandler = new ResponseHandler(this, Looper.getMainLooper());

    @Override
    protected void sendMessage(ProgressBean progressBean) {
        mHandler.obtainMessage(UPLOAD_PROGRESS,progressBean).sendToTarget();

    }

    @Override
    protected void handleMessage(Message message){
        switch (message.what){
            case UPLOAD_PROGRESS:
                ProgressBean progressBean = (ProgressBean)message.obj;
                onProgress(progressBean.getBytesRead(),progressBean.getContentLength(),progressBean.isDone());
        }
    }

}
