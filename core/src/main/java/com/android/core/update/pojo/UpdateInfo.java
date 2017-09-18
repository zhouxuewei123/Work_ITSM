package com.android.core.update.pojo;


/**
 * {
 "status":1,(请求是否成功（1成功其他否）)
 "isForce":1,(是否强制更新（1是0否）)
 "apkUrl":"http://dl.m.duoku.com/game/49000/49554/20150206145821_DuoKu.apk",(下载url)
 "versionCode":14,(版本号)
 "updateTips":"update1.1.7.2",(更新标题)
 "versionName":"1.1.7.2",(版本名)
 "changeLog":"1.新增了用户信息的采集<br>2.修复了路径规划节点超过1000个异常崩溃的bug",(更新说明)
 "size":"25M"(包大小)
 *}
 */
public class UpdateInfo {
	private Integer status;
    private String appName;
    private String packageName;
    private String versionCode;
    private String versionName;
    private String apkUrl;
    private String changeLog;
    private String updateTips;
    
    private String created_at;
    private String size;
    private Integer isForce;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getIsForce() {
		return isForce;
	}

	public void setIsForce(Integer isForce) {
		this.isForce = isForce;
	}

	public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getApkUrl() {
        return apkUrl;
    }

    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }

    public String getUpdateTips() {
        return updateTips;
    }

    public void setUpdateTips(String updateTips) {
        this.updateTips = updateTips;
    }

    public String getChangeLog() {
        return changeLog;
    }

    public void setChangeLog(String changeLog) {
        this.changeLog = changeLog;
    }
}
