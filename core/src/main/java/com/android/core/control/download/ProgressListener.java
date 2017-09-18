package com.android.core.control.download;

/**
 * @Description:
 * @author: ragkan
 * @time: 2016/7/27 14:02
 */
public interface ProgressListener {
    /**
     * @param progress     已经下载或上传字节数
     * @param total        总字节数
     * @param done         是否完成
     */
    void onProgress(long progress, long total, boolean done);
}
