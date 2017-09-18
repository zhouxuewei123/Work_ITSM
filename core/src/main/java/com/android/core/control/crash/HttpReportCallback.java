package com.android.core.control.crash;

import java.io.File;

/**
 * @Description: 
 * @author: ragkan
 * @time: 2016/11/1 14:35
 */
public interface HttpReportCallback {

    void uploadException2remote(File file);
}
