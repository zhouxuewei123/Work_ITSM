package com.android.core.update.utils;

import com.android.core.update.pojo.UpdateInfo;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ShelWee on 14-5-8.
 */
public class JSONHandler {

    public static UpdateInfo toUpdateInfo(InputStream is) throws Exception {
        if (is == null){
            return null;
        }
        String byteData = new String(readStream(is));
        is.close();
        JSONObject jsonObject = new JSONObject(byteData);
        UpdateInfo updateInfo = new UpdateInfo();
        if(jsonObject.has("apkUrl")) updateInfo.setApkUrl(jsonObject.getString("apkUrl"));
        if(jsonObject.has("appName")) updateInfo.setAppName(jsonObject.getString("appName"));
        if(jsonObject.has("versionCode")) updateInfo.setVersionCode(jsonObject.getString("versionCode"));
        if(jsonObject.has("versionName")) updateInfo.setVersionName(jsonObject.getString("versionName"));
//        if(jsonObject.has("changeLog")) updateInfo.setChangeLog(jsonObject.getString("changeLog").replaceAll("<br />", "\n").replaceAll("<br/>", "\n").replaceAll("<br >", "\n").replaceAll("<br>", "\n"));
        if(jsonObject.has("changeLog")) updateInfo.setChangeLog(jsonObject.getString("changeLog").replaceAll("<br\\s*/?>", "\n"));
        if(jsonObject.has("updateTips")) updateInfo.setUpdateTips(jsonObject.getString("updateTips"));
        if(jsonObject.has("status")) updateInfo.setStatus(jsonObject.getInt("status"));
        if(jsonObject.has("created_at")) updateInfo.setCreated_at(jsonObject.getString("created_at"));
        if(jsonObject.has("size")) updateInfo.setSize(jsonObject.getString("size"));
        if(jsonObject.has("isForce")) updateInfo.setIsForce(jsonObject.getInt("isForce"));
        return updateInfo;
    }

    private static byte[] readStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        byte [] array=new byte[1024];
        int len = 0;
        while( (len = inputStream.read(array)) != -1){
            outputStream.write(array,0,len);
        }
        inputStream.close();
        outputStream.close();
        return outputStream.toByteArray();
    }

}
